package com.example.booking.core;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservationRequest {
    private String eventId;
    private String venueId;
    private String areaId;
    private String userId;
}
