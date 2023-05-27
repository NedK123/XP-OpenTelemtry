package org.example.pricing.core;

public interface EventTicketsPriceStorage {
    TicketPrice fetch(String eventId, String areaId) throws TicketPriceNotFoundException;
}
