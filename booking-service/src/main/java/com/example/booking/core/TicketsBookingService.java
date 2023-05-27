package com.example.booking.core;

import com.example.booking.core.events.IEventsService;
import com.example.booking.core.payment.PaymentService;
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

    @Override
    public TicketsBooking book(BookTicketsRequest request) throws BookingFailedException {
        if (!eventsService.eventIsRegistered(request.getEventId())) {
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
            eventsService.updateAvailability(ticketsBooking.getEventId(), ticketsBooking.getTicketsIds());
            paymentService.processPayment(ticketsBooking);
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
