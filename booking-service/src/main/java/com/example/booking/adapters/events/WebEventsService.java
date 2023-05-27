package com.example.booking.adapters.events;

import com.example.booking.core.events.details.EventDetails;
import com.example.booking.core.events.details.EventsDetailsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class WebEventsService implements EventsDetailsService {

    private EventsFeignClient client;

    @Override
    public EventDetails get(String eventId) {
        EventDetails eventDetails = client.getEvent(eventId).getBody();
        log.info("Fetched event details={}", eventDetails);
        return eventDetails;
    }

}
