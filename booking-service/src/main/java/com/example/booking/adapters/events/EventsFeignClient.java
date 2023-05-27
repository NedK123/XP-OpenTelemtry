package com.example.booking.adapters.events;

import com.example.booking.config.FeignTracingConfiguration;
import com.example.booking.core.events.details.EventDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "events-service", configuration = FeignTracingConfiguration.class)
public interface EventsFeignClient {

    @GetMapping("events/{id}")
    ResponseEntity<EventDetails> getEvent(@PathVariable("id") String eventId);

}
