package org.example.pricing.adapters;

import org.example.pricing.config.FeignTracingConfiguration;
import org.example.pricing.core.booking.Booking;
import org.example.pricing.core.booking.BookingNotFoundException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "booking-service", configuration = FeignTracingConfiguration.class)
public interface BookingServiceFeignClient {

    @GetMapping("booking/{id}")
    ResponseEntity<Booking> get(@PathVariable("id") String bookingId) throws BookingNotFoundException;

}
