package org.example.events.core;

public class EventNotFoundException extends Exception {
    public EventNotFoundException(String eventId) {
        super(String.format("Event with id=%s was not found", eventId));
    }
}
