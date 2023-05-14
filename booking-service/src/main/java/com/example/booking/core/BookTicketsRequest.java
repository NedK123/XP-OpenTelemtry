package com.example.booking.core;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookTicketsRequest {
    private String userId;
    private String eventId;
    private String venueId;
    private String areaId;
    private int numberOfTickets;
}
