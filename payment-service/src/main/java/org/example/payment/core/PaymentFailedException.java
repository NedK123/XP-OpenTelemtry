package org.example.payment.core;

import static java.lang.String.format;

public class PaymentFailedException extends Exception {

    public PaymentFailedException(String bookingId) {
        super(format("Alas! payment for booking %s failed", bookingId));
    }

}
