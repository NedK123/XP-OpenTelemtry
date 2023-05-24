package org.example.pricing.core.booking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    private String id;
    private String eventId;
    private String areaId;
    private Set<String> ticketsIds;
}
