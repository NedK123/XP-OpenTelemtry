package org.example.pricing.api;

import io.micrometer.observation.annotation.Observed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.pricing.core.BookingPrice;
import org.example.pricing.core.FailedToPriceBookingException;
import org.example.pricing.core.PricingService;
import org.example.pricing.core.RegisterTicketsPricesRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@Observed
@RestController
@AllArgsConstructor
@Slf4j
public class PricingController implements PricingApi {

    private PricingService pricingService;

    @Override
    public ResponseEntity<BookingPrice> generatePrice(GeneratePricingRequest request) throws FailedToPriceBookingException {
        log.info("Received price quote request={}", request);
        BookingPrice price = pricingService.calculatePrice(request.getBookingId());
        return ResponseEntity.ok(price);
    }

    @Override
    public ResponseEntity<Void> registerTicketsPrice(RegisterTicketsPriceApiRequest request) {
        log.info("Received a tickets prices registration request={}", request);
        pricingService.registerTicketsPrice(RegisterTicketsPricesRequest.builder()
                .eventId(request.getEventId()).currency(request.getCurrency())
                .areaPrices(request.getAreaPrices()).build());
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(value = FailedToPriceBookingException.class)
    public ResponseEntity<Void> handle(FailedToPriceBookingException exception) {
        log.error("", exception);
        return ResponseEntity.notFound().build();
    }

}
