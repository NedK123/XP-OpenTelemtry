package org.example.pricing.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTicketsPriceRepo extends CrudRepository<TicketPriceEntity, String> {
}
