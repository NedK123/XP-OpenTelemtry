package com.example.booking.core.events;

import com.example.booking.persistence.EventAvailability;

import java.util.Set;

public interface EventsStorage {

    void createIfNotFound(CreateEventRequest request);

    void updateAvailability(String eventId, Set<String> bookedTickets) throws EventNotFoundException;

    EventAvailability get(String eventId) throws EventNotFoundException;

    boolean exists(String eventId);
}
