package org.example.events.persistence;

import org.example.events.api.CreateNewEventRequest;
import org.example.events.core.Event;
import org.example.events.core.EventNotFoundException;
import org.example.events.core.EventsStorage;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EventsRedisStorage implements EventsStorage {

    private EventsRepo repo;

    @Override
    public Event getEvent(String id) throws EventNotFoundException {
        return repo.findById(id).orElseThrow(EventNotFoundException::new);
    }

    @Override
    public String save(CreateNewEventRequest request) {
        Event event = Event.builder().id(UUID.randomUUID().toString()).build();
        return repo.save(event).getId();
    }

}
