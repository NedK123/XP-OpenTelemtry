package com.example.booking.persistence;

import com.example.booking.core.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationsRepo extends CrudRepository<Reservation, String> {

}
