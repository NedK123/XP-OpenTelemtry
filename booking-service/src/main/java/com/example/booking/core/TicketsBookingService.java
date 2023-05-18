package com.example.booking.core;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class TicketsBookingService implements BookingService {

    private TemporaryReservationService reservationService;

    @Override
    public TicketsBooking book(BookTicketsRequest request) throws BookingFailedException {
        Reservation reservation = reserve(request);
        return TicketsBooking.builder().bookingId(reservation.getId()).ticketsIds(reservation.getTickets()).build();
    }

    private Reservation reserve(BookTicketsRequest request) throws BookingFailedException {
        try {
            return reservationService.reserve(map(request));
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
