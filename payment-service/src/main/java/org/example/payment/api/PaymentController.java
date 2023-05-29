package org.example.payment.api;

import io.micrometer.observation.annotation.Observed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.payment.core.PayRequest;
import org.example.payment.core.Payment;
import org.example.payment.core.PaymentFailedException;
import org.example.payment.core.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@Observed
@RestController
@AllArgsConstructor
@Slf4j
public class PaymentController implements PaymentApi {

    private PaymentService paymentService;

    @Override
    public ResponseEntity<Payment> pay(PayApiRequest request) throws PaymentFailedException {
        log.info("Received a payment request={}", request);
        Payment payment = paymentService.pay(PayRequest.builder().bookingId(request.getBookingId()).build());
        return ResponseEntity.ok(payment);
    }

    @ExceptionHandler(value = PaymentFailedException.class)
    public ResponseEntity<Void> handle(PaymentFailedException exception) {
        log.error("", exception);
        return ResponseEntity.notFound().build();
    }

}
