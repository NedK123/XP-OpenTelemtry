package org.example.payment.core;

public interface PaymentService {
    Payment pay(PayRequest request) throws PaymentFailedException;
}
