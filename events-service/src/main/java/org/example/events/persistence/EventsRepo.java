package org.example.events.persistence;

import org.example.events.core.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepo extends CrudRepository<Event, String> {
}
