package com.example.booking.adapters;

import com.example.booking.core.events.details.EventDetails;
import com.example.booking.core.events.details.EventsDetailsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@AllArgsConstructor
@Slf4j
public class WebEventsService implements EventsDetailsService {

    private WebClient webClient;

    @Override
    public EventDetails get(String eventId) {
        return webClient.get().uri(getEventApiPath(eventId)).retrieve().bodyToMono(EventDetails.class).block();
    }

    private static URI getEventApiPath(String eventId) {
        return UriComponentsBuilder.fromUriString("http://localhost:8081/events/{id}").buildAndExpand(eventId).toUri();
    }

}
