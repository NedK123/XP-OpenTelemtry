package com.example.booking.core;

public interface BookingService {

    TicketsBooking book(BookTicketsRequest request) throws BookingFailedException;

    TicketsBooking get(String bookingId) throws BookingNotFoundException;

}
