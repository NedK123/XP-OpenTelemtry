package com.example.booking.core.events;

import com.example.booking.core.events.details.EventDetails;
import com.example.booking.core.events.details.EventsDetailsService;
import com.example.booking.persistence.EventAvailability;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class EventsService implements IEventsService {

    private EventsDetailsService eventsDetailsService;
    private EventsStorage storage;

    @Override
    public Event get(String eventId) throws EventNotFoundException {
        EventAvailability eventAvailability = storage.get(eventId);
        EventDetails eventDetails = eventsDetailsService.get(eventId);
        return Event.builder().id(eventId).capacity(eventAvailability.getCapacity())
                .bookedTickets(eventAvailability.getBookedTickets()).date(eventDetails.getDate()).build();
    }

    @Override
    public boolean eventIsRegistered(String eventId) {
        return storage.exists(eventId);
    }

    @Override
    public void register(String eventId) {
        EventDetails eventDetails = eventsDetailsService.get(eventId);
        CreateEventRequest request = CreateEventRequest.builder().eventId(eventId)
                .capacity(eventDetails.getTotalNumOfTickets()).build();
        storage.createIfNotFound(request);
    }

}
