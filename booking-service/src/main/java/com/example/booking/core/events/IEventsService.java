package com.example.booking.core.events;

import java.util.Set;

public interface IEventsService {
    Event get(String eventId) throws EventNotFoundException;

    boolean eventIsRegistered(String eventId);

    void register(String eventId);

    void updateAvailability(String eventId, Set<String> ticketsIds) throws EventNotFoundException;
}
