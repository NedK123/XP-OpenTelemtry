package com.example.booking.adapters;

import com.example.booking.config.FeignTracingConfiguration;
import com.example.booking.core.events.details.EventDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Events", url = "http://localhost:8081/events/", configuration = FeignTracingConfiguration.class)
public interface EventsFeignClient {

    @GetMapping("/{id}")
    ResponseEntity<EventDetails> getEvent(@PathVariable("id") String eventId);

}
