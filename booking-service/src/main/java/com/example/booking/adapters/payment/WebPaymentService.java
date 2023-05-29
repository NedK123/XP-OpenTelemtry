package com.example.booking.adapters.payment;

import com.example.booking.core.TicketsBooking;
import com.example.booking.core.payment.PaymentFailedException;
import com.example.booking.core.payment.PaymentService;
import io.micrometer.observation.annotation.Observed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Observed
@Service
@AllArgsConstructor
@Slf4j
public class WebPaymentService implements PaymentService {

    private PaymentServiceFeignClient client;

    @Override
    public void processPayment(TicketsBooking ticketsBooking) throws PaymentFailedException {
        log.info("Calling payment service for booking={}", ticketsBooking);
        PayApiRequest build = PayApiRequest.builder().bookingId(ticketsBooking.getId()).build();
        client.pay(build);
    }

}
