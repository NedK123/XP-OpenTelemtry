package org.example.payment.adapters;

import org.example.payment.core.pricing.BookingPrice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "pricing-service")
public interface PricingServiceFeignClient {

    @PostMapping("pricing/")
    ResponseEntity<BookingPrice> generatePrice(@RequestBody GeneratePricingRequest request);

}
