package org.example.pricing.persistence;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.pricing.core.EventTicketsPriceStorage;
import org.example.pricing.core.TicketPrice;
import org.example.pricing.core.TicketPriceNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class RedisEventTicketsPriceStorage implements EventTicketsPriceStorage {

    private EventTicketsPriceRepo repo;

    @Override
    public TicketPrice fetch(String eventId, String areaId) throws TicketPriceNotFoundException {
        TicketPriceEntity entity = repo.findById(map(eventId, areaId)).orElseThrow(TicketPriceNotFoundException::new);
        return map(entity);
    }

    private TicketPrice map(TicketPriceEntity entity) {
        return TicketPrice.builder().amount(entity.getAmount()).currency(entity.getCurrency()).build();
    }

    private String map(String eventId, String areaId) {
        return String.format("%s-%s", eventId, areaId);
    }

}
