package org.example.pricing.persistence;

import org.example.pricing.core.TicketPrice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTicketsPriceRepo extends CrudRepository<TicketPrice, String> {
}
