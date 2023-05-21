package com.example.booking.core;

public class BookingNotFoundException extends Exception {

    public BookingNotFoundException(String id) {
        super(String.format("Booking with id=%s was not found", id));
    }
}
