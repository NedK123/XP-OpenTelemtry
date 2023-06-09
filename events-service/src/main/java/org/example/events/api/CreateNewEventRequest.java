package org.example.events.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateNewEventRequest {
    private String venueId;
    private int totalNumOfTickets;
    private Date date;
}
