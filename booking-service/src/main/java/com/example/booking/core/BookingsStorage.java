package com.example.booking.core;

public interface BookingsStorage {

    TicketsBooking registerBooking(ReservationRequest request) throws FailedToReserveException;

    TicketsBooking fetch(String bookingId) throws BookingNotFoundException;

}
