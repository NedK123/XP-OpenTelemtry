package org.example.payment.api;

import org.example.payment.core.Payment;
import org.example.payment.core.PaymentFailedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("payment/")
public interface PaymentApi {

    @PostMapping("")
    ResponseEntity<Payment> pay(@RequestBody PayApiRequest request) throws PaymentFailedException;

}
