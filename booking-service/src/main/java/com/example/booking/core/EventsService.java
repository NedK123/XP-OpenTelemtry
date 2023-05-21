package com.example.booking.core;

import com.example.booking.core.events.Event;
import org.springframework.stereotype.Service;

@Service
public interface EventsService {
    Event get(String eventId);

    boolean eventIsRegistered(String eventId);

    void register(String eventId);
}
