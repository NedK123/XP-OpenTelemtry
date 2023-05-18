package com.example.booking.core;

import org.springframework.stereotype.Service;

@Service
public interface TemporaryReservationService {

    Reservation reserve(ReservationRequest request) throws FailedToReserveException;

}
