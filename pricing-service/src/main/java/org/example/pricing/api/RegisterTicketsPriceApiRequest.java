package org.example.pricing.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterTicketsPriceApiRequest implements Serializable {
    private String eventId;
    private String currency;
    @Builder.Default
    private Map<String, Double> areaPrices = new HashMap<>();
}
