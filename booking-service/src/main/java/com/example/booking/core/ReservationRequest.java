package com.example.booking.core;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservationRequest {
    private String eventId;
    private int numberOfTickets;
    private String userId;
    private String areaId;
    private String venueId;
}
