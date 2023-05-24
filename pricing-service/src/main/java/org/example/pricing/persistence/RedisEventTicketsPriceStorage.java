package org.example.pricing.persistence;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.pricing.core.EventTicketsPriceStorage;
import org.example.pricing.core.TicketPrice;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class RedisEventTicketsPriceStorage implements EventTicketsPriceStorage {

    private EventTicketsPriceRepo repo;

    @Override
    public TicketPrice fetch(String eventId, String areaId) {
        return null;
    }

}
