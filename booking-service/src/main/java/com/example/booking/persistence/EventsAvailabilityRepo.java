package com.example.booking.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsAvailabilityRepo extends CrudRepository<EventAvailability, String> {
}
