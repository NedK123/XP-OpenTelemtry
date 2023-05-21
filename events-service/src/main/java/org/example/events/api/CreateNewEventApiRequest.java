package org.example.events.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateNewEventApiRequest {
    private String venueId;
    private int totalNumOfTickets;
    private String date;
}
