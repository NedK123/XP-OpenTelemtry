package org.example.payment.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private String id;
    private String bookingId;
    private double amount;
    private String currency;
}
