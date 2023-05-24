package org.example.payment.adapters;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.payment.core.pricing.BookingPrice;
import org.example.payment.core.pricing.PricingService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PricingAdapter implements PricingService {

    private PricingServiceFeignClient client;

    @Override
    public BookingPrice calculate(String bookingId) {
        return null;
    }

}
