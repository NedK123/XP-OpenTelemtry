package com.example.booking.core;

import java.util.List;

public interface TicketsFetcher {
    List<Ticket> fetch(String areaId);
}
