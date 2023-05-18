package com.example.booking.persistence;

import com.example.booking.core.FailedToReserveException;
import com.example.booking.core.Reservation;
import com.example.booking.core.ReservationRequest;
import com.example.booking.core.TemporaryReservationService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

@AllArgsConstructor
public class ReddisTemporaryReservationService implements TemporaryReservationService {

    private ReservationsRepo reservationsRepo;

    @Override
    public Reservation reserve(ReservationRequest request) throws FailedToReserveException {
        // randomly saves some requests and reject other to simulate real life scenarios
        if (new Random().nextBoolean()) {
            Reservation reservation = Reservation.builder().id(UUID.randomUUID().toString())
                    .tickets(generateTickets(request.getNumberOfTickets())).build();
            return reservationsRepo.save(reservation);
        }
        throw new FailedToReserveException("oh no! something went wrong wait doing a reservation");
    }

    private static List<String> generateTickets(int numberOfTickets) {
        return IntStream.of(numberOfTickets).mapToObj(i -> UUID.randomUUID().toString()).toList();
    }

}
