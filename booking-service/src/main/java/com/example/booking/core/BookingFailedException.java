package com.example.booking.core;

public class BookingFailedException extends Exception {
    public BookingFailedException(Exception e) {
        super(e);
    }

}
