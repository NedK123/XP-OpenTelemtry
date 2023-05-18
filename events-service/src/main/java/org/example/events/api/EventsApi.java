package org.example.events.api;

import org.example.events.core.Event;
import org.example.events.core.EventNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("events/")
public interface EventsApi {

    @PostMapping("")
    ResponseEntity<String> createEvent(CreateNewEventRequest event);

    @GetMapping("/{id}")
    ResponseEntity<Event> getEvent(@PathVariable("id") String eventId) throws EventNotFoundException;

}
