package com.example.booking.persistence;

import com.example.booking.core.TicketsBooking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingsRepo extends CrudRepository<TicketsBooking, String> {

}
