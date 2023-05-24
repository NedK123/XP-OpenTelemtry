package org.example.payment.adapters;

import org.example.payment.config.FeignTracingConfiguration;
import org.example.payment.core.pricing.BookingPrice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Pricing", url = "http://localhost:8083/pricing/", configuration = FeignTracingConfiguration.class)
public interface PricingServiceFeignClient {

    @PostMapping("")
    ResponseEntity<BookingPrice> generatePrice(@RequestBody GeneratePricingRequest request);

}
