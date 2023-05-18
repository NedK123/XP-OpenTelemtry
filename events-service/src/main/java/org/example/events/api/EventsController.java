package org.example.events.api;

import lombok.AllArgsConstructor;
import org.example.events.core.Event;
import org.example.events.core.EventCreator;
import org.example.events.core.EventFetcher;
import org.example.events.core.EventNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@AllArgsConstructor
public class EventsController implements EventsApi {

    private EventCreator eventCreator;
    private EventFetcher eventFetcher;

    @Override
    public ResponseEntity<String> createEvent(CreateNewEventRequest request) {
        String eventId = eventCreator.create(request);
        return ResponseEntity.created(URI.create("events/" + eventId)).build();
    }

    @Override
    public ResponseEntity<Event> getEvent(String eventId) throws EventNotFoundException {
        return ResponseEntity.ok(eventFetcher.getEvent(eventId));
    }

    @ExceptionHandler(value = EventNotFoundException.class)
    public ResponseEntity<String> handle(EventNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }


}
