package com.example.booking.core;

import com.example.booking.core.events.CreateEventRequest;

import java.util.List;

public interface EventsStorage {

    void createIfNotFound(CreateEventRequest request);

    void updateAvailability(List<String> bookedTickets);

}
