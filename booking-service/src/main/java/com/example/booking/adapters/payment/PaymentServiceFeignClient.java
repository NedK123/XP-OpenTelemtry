package com.example.booking.adapters.payment;

import com.example.booking.core.payment.PaymentFailedException;
import io.micrometer.observation.annotation.Observed;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Observed
@FeignClient(name = "payment-service")
public interface PaymentServiceFeignClient {

    @PostMapping("payment/")
    ResponseEntity<PaymentApiModel> pay(@RequestBody PayApiRequest request) throws PaymentFailedException;

}
