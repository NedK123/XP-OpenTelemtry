package com.example.booking.core.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Event implements Serializable {
    private String id;
    private int capacity;
    private List<String> bookedTickets;
}
