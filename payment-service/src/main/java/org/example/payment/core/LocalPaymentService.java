package org.example.payment.core;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.payment.core.pricing.BookingPrice;
import org.example.payment.core.pricing.PricingService;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
@Slf4j
public class LocalPaymentService implements PaymentService {

    private PricingService pricingService;

    @Override
    public Payment pay(PayRequest request) throws PaymentFailedException {
        BookingPrice price = pricingService.calculate(request.getBookingId());
        simulate(request.getBookingId(), price);
        return Payment.builder().id(UUID.randomUUID().toString()).amount(price.getAmount()).currency(price.getCurrency()).bookingId(request.getBookingId()).build();
    }

    private void simulate(String bookingId, BookingPrice price) throws PaymentFailedException {
        try {
            log.info("paying for booking {} price={}{} underway...", bookingId, price.getAmount(), price.getCurrency());
            TimeUnit.SECONDS.sleep(new Random().nextInt(5));
            if (new Random().nextBoolean()) {
                log.info("payment for booking {} was successful", bookingId);
            } else {
                throw new PaymentFailedException(bookingId);
            }
        } catch (InterruptedException e) {
            log.error("", e);
            throw new PaymentFailedException(bookingId);
        }
    }

}
