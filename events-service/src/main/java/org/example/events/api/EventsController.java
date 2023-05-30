package org.example.events.api;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.events.core.Event;
import org.example.events.core.EventCreator;
import org.example.events.core.EventFetcher;
import org.example.events.core.EventNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@AllArgsConstructor
@Slf4j
public class EventsController implements EventsApi {

    private EventCreator eventCreator;
    private EventFetcher eventFetcher;

    @Override
    public ResponseEntity<String> createEvent(CreateNewEventApiRequest request) throws ParseException {
        String eventId = eventCreator.create(map(request));
        return ResponseEntity.created(URI.create("events/" + eventId)).build();
    }

    @Override
    public ResponseEntity<Event> getEvent(String eventId) throws EventNotFoundException {
        return ResponseEntity.ok(eventFetcher.getEvent(eventId));
    }

    @ExceptionHandler(value = EventNotFoundException.class)
    public ResponseEntity<String> handle(EventNotFoundException exception) {
        log.error("", exception);
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(value = ParseException.class)
    public ResponseEntity<String> handle(ParseException exception) {
        log.error("", exception);
        return ResponseEntity.badRequest().build();
    }

    private CreateNewEventRequest map(CreateNewEventApiRequest request) throws ParseException {
        return CreateNewEventRequest.builder().venueId(request.getVenueId())
                .totalNumOfTickets(request.getTotalNumOfTickets()).date(resolveDate(request.getDate())).build();
    }

    private Date resolveDate(String date) throws ParseException {
        return new SimpleDateFormat(DATE_PATTERN).parse(date);
    }


}
