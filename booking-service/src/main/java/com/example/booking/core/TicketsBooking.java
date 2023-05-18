package com.example.booking.core;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TicketsBooking {
    private String bookingId;
    private List<String> ticketsIds;
}
