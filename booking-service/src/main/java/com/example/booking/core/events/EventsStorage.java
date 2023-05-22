package com.example.booking.core.events;

import com.example.booking.persistence.EventAvailability;

import java.util.List;

public interface EventsStorage {

    void createIfNotFound(CreateEventRequest request);

    void updateAvailability(List<String> bookedTickets);

    EventAvailability get(String eventId) throws EventNotFoundException;

    boolean exists(String eventId);
}
