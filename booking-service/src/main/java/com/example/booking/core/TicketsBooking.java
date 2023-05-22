package com.example.booking.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Booking")
public class TicketsBooking {
    private String id;
    private String eventId;
    private String areaId;
    private Set<String> ticketsIds;
}
