package org.example.pricing.core;

public interface PricingService {
    BookingPrice calculatePrice(String bookingId) throws FailedToPriceBookingException;
}
