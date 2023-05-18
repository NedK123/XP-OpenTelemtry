package org.example.events.core;

import org.example.events.api.CreateNewEventRequest;

public interface EventsStorage {
    Event getEvent(String id) throws EventNotFoundException;

    String save(CreateNewEventRequest request);
}
