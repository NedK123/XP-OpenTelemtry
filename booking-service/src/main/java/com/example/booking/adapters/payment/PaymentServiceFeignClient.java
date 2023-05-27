package com.example.booking.adapters.payment;

import com.example.booking.config.FeignTracingConfiguration;
import com.example.booking.core.payment.PaymentFailedException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "payment", url = "http://localhost:8082/payment/", configuration = FeignTracingConfiguration.class)
public interface PaymentServiceFeignClient {

    @PostMapping("")
    ResponseEntity<PaymentApiModel> pay(PayApiRequest request) throws PaymentFailedException;

}
