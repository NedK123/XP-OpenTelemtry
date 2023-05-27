package org.example.pricing.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("TicketPriceEntity")
public class TicketPriceEntity implements Serializable {
    private String id;
    private double amount;
    private String currency;
}
