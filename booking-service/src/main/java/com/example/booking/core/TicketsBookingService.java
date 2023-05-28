package com.example.booking.core;

import com.example.booking.core.events.IEventsService;
import com.example.booking.core.payment.PaymentService;
import io.micrometer.observation.annotation.Observed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class TicketsBookingService implements BookingService {

    private BookingsStorage bookingsStorage;
    private IEventsService eventsService;
    private PaymentService paymentService;

    @Observed(name = "user.name",
            contextualName = "booking-tickets",
            lowCardinalityKeyValues = {"userType", "userType2"})
    @Override
    public TicketsBooking book(BookTicketsRequest request) throws BookingFailedException {
        log.info("Processing booking request={}", request);
        if (!eventsService.eventIsRegistered(request.getEventId())) {
            log.info("registering event for the first time in the booking records");
            eventsService.register(request.getEventId());
        }
        return reserve(request);
    }

    @Override
    public TicketsBooking get(String bookingId) throws BookingNotFoundException {
        return bookingsStorage.fetch(bookingId);
    }

    private TicketsBooking reserve(BookTicketsRequest request) throws BookingFailedException {
        try {
            TicketsBooking ticketsBooking = bookingsStorage.registerBooking(map(request));
            log.info("Booking {} was registered", request);
            eventsService.updateAvailability(ticketsBooking.getEventId(), ticketsBooking.getTicketsIds());
            log.info("Event {} availability updated after booking {}", request.getEventId(), ticketsBooking);
            paymentService.processPayment(ticketsBooking);
            log.info("Payment for booking {} was successful", ticketsBooking.getId());
            return ticketsBooking;
        } catch (Exception e) {
            log.error("An error occurred while booking tickets for request={}", request, e);
            throw new BookingFailedException(e);
        }
    }

    private static ReservationRequest map(BookTicketsRequest request) {
        return ReservationRequest.builder().eventId(request.getEventId())
                .areaId(request.getAreaId()).userId(request.getUserId())
                .numberOfTickets(request.getNumberOfTickets()).build();
    }

}
