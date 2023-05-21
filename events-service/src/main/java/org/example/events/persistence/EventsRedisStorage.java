package org.example.events.persistence;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.example.events.api.CreateNewEventRequest;
import org.example.events.core.Event;
import org.example.events.core.EventNotFoundException;
import org.example.events.core.EventsStorage;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class EventsRedisStorage implements EventsStorage {

    private EventsRepo repo;

    @Override
    public Event getEvent(String id) throws EventNotFoundException {
        simulateLatency();
        return repo.findById(id).orElseThrow(() -> new EventNotFoundException(id));
    }

    @Override
    public String save(CreateNewEventRequest request) {
        simulateLatency();
        Event event = Event.builder().id(UUID.randomUUID().toString()).totalNumOfTickets(request.getTotalNumOfTickets()).date(request.getDate()).build();
        return repo.save(event).getId();
    }

    @SneakyThrows
    private static void simulateLatency() {
        TimeUnit.SECONDS.sleep(new Random().nextInt(5));
    }

}
