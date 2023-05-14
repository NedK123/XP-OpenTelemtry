package com.example.booking.core;

import java.util.List;

public class TicketsBookingService implements BookingService {

    private TicketsFetcher ticketsFetcher;

    private BookingAvailabilityChecker bookingAvailability;

    private TemporaryReservationService reservationService;

    @Override
    public TicketsBooking book(BookTicketsRequest request) throws BookingFailedException {
        List<Ticket> tickets = ticketsFetcher.fetch(request.getAreaId());

        reserve(request);
        // reserve places
        // updates event availability
        // generate tickets
        //

        return null;
    }

    private Reservation reserve(BookTicketsRequest request) throws BookingFailedException {
        try {
            ReservationRequest rsvRequest = ReservationRequest.builder().eventId(request.getEventId())
                    .venueId(request.getVenueId()).areaId(request.getAreaId()).userId(request.getUserId()).build();
            return reservationService.reserve(rsvRequest);
        } catch (FailedToReserveException e) {
            throw new BookingFailedException(e);
        }
    }

}
