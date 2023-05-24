package org.example.pricing.api;

import org.example.pricing.core.BookingPrice;
import org.example.pricing.core.FailedToPriceBookingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("pricing/")
public interface PricingApi {

    @PostMapping("")
    ResponseEntity<BookingPrice> generatePrice(@RequestBody GeneratePricingRequest request) throws FailedToPriceBookingException;

}
