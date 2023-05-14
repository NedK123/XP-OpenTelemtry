package com.example.booking.core;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class TicketsBooking {
    private String bookingId;
    private List<String> ticketsIds;
    private Date bookingDate;
    private String userId;
}
