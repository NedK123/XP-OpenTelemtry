package org.example.pricing.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterTicketsPricesRequest {
    private String eventId;
    private String currency;
    private Map<String, Double> areaPrices;
}
