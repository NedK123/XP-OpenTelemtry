package org.example.events.core;

import lombok.AllArgsConstructor;
import org.example.events.api.CreateNewEventRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventCreationService implements EventCreator {

    private EventsStorage repo;

    @Override
    public String create(CreateNewEventRequest request) {
        return repo.save(request);
    }

}
