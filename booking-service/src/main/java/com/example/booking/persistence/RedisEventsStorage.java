package com.example.booking.persistence;

import com.example.booking.core.EventsStorage;
import com.example.booking.core.events.CreateEventRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void updateAvailability(List<String> bookedTickets) {

    }

}
