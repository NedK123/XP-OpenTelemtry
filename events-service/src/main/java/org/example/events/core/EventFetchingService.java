package org.example.events.core;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventFetchingService implements EventFetcher {

    private EventsStorage storage;

    @Override
    public Event getEvent(String id) throws EventNotFoundException {
        return storage.getEvent(id);
    }

}
