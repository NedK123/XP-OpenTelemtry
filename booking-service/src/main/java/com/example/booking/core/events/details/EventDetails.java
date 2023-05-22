package com.example.booking.core.events.details;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventDetails implements Serializable {
    private String id;
    private int totalNumOfTickets;
    private Date date;
    private String venueId;
}
