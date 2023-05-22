package com.example.booking.persistence;

import com.example.booking.core.events.CreateEventRequest;
import com.example.booking.core.events.EventNotFoundException;
import com.example.booking.core.events.EventsStorage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class RedisEventsStorage implements EventsStorage {

    private EventsAvailabilityRepo repo;

    @Override
    public void createIfNotFound(CreateEventRequest request) {
        repo.save(EventAvailability.builder().id(request.getEventId()).capacity(request.getCapacity()).build());
    }

    @Override
    public void updateAvailability(String eventId, Set<String> bookedTickets) throws EventNotFoundException {
        EventAvailability eventAvailability = repo.findById(eventId).map(event -> {
            event.book(bookedTickets);
            return event;
        }).orElseThrow(EventNotFoundException::new);
        repo.save(eventAvailability);
    }

    @Override
    public EventAvailability get(String eventId) throws EventNotFoundException {
        return repo.findById(eventId).orElseThrow(EventNotFoundException::new);
    }

    @Override
    public boolean exists(String eventId) {
        return repo.existsById(eventId);
    }

}
