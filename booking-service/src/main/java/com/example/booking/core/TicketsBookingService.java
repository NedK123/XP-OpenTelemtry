package com.example.booking.core;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class TicketsBookingService implements BookingService {

    private BookingsStorage bookingsStorage;
    private EventsService eventsService;

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
            return bookingsStorage.registerBooking(map(request));
        } catch (FailedToReserveException e) {
            log.error("An error occurred while booking tickets for request={}", request, e);
            throw new BookingFailedException(e);
        }
    }

    private static ReservationRequest map(BookTicketsRequest request) {
        return ReservationRequest.builder().eventId(request.getEventId())
                .venueId(request.getVenueId()).areaId(request.getAreaId()).userId(request.getUserId())
                .numberOfTickets(request.getNumberOfTickets()).build();
    }

}
