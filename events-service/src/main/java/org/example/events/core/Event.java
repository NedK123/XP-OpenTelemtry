package org.example.events.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Event")
public class Event implements Serializable {
    private String id;
    private int totalNumOfTickets;
    private Date date;
}
