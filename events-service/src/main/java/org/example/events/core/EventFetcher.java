package org.example.events.core;

public interface EventFetcher {

    Event getEvent(String id) throws EventNotFoundException;

}
