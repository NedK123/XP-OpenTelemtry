package com.example.booking.core.events;

public interface IEventsService {
    Event get(String eventId) throws EventNotFoundException;

    boolean eventIsRegistered(String eventId);

    void register(String eventId);
}
