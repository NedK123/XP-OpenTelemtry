package com.example.booking.core.payment;

import com.example.booking.core.TicketsBooking;

public interface PaymentService {
    void processPayment(TicketsBooking ticketsBooking) throws PaymentFailedException;
}
