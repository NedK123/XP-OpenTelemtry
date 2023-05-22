package com.example.booking.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("EventAvailability")
public class EventAvailability implements Serializable {
    private String id;
    private int capacity;
    @Builder.Default
    private Set<String> bookedTickets = new HashSet<>();

    public void book(Set<String> bookedTickets) {
        this.capacity -= bookedTickets.size();
        this.bookedTickets.addAll(bookedTickets);
    }

}
