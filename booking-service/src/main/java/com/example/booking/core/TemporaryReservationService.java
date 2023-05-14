package com.example.booking.core;

public interface TemporaryReservationService {

    Reservation reserve(ReservationRequest request) throws FailedToReserveException;

}
