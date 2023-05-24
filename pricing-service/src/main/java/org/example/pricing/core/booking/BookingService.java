package org.example.pricing.core.booking;

public interface BookingService {
    Booking fetch(String bookingId) throws BookingNotFoundException;
}
