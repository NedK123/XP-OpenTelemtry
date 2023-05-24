package org.example.pricing.api;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.pricing.core.BookingPrice;
import org.example.pricing.core.FailedToPriceBookingException;
import org.example.pricing.core.PricingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class PricingController implements PricingApi {

    private PricingService pricingService;

    @Override
    public ResponseEntity<BookingPrice> generatePrice(GeneratePricingRequest request) throws FailedToPriceBookingException {
        BookingPrice price = pricingService.calculatePrice(request.getBookingId());
        return ResponseEntity.ok(price);
    }

    @ExceptionHandler(value = FailedToPriceBookingException.class)
    public ResponseEntity<Void> handle(FailedToPriceBookingException exception) {
        log.error("", exception);
        return ResponseEntity.notFound().build();
    }

}
