package org.example.events.core;

import org.example.events.api.CreateNewEventRequest;

public interface EventCreator {

    String create(CreateNewEventRequest request);

}
