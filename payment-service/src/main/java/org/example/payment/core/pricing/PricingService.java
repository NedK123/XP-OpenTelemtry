package org.example.payment.core.pricing;

public interface PricingService {
    BookingPrice calculate(String bookingId);
}
