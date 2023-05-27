package com.example.booking.adapters.payment;

import com.example.booking.core.TicketsBooking;
import com.example.booking.core.payment.PaymentFailedException;
import com.example.booking.core.payment.PaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class WebPaymentService implements PaymentService {

    private PaymentServiceFeignClient client;

    @Override
    public void processPayment(TicketsBooking ticketsBooking) throws PaymentFailedException {
        client.pay(PayApiRequest.builder().bookingId(ticketsBooking.getId()).build());
    }

}
