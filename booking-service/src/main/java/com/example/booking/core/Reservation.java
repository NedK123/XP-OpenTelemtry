package com.example.booking.core;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@RedisHash("Reservation")
public class Reservation implements Serializable {
    private String id;
    private List<String> tickets;
}
