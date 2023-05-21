package com.example.booking.persistence;

import com.example.booking.core.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

@Service
@AllArgsConstructor
public class RedisBookingsStorage implements BookingsStorage {

    private BookingsRepo bookingsRepo;

    @Override
    public TicketsBooking registerBooking(ReservationRequest request) throws FailedToReserveException {
        // randomly saves some requests and reject other to simulate real life scenarios
        if (new Random().nextBoolean()) {
            TicketsBooking booking = TicketsBooking.builder().id(UUID.randomUUID().toString())
                    .ticketsIds(generateTickets(request.getNumberOfTickets())).build();
            return bookingsRepo.save(booking);
        }
        throw new FailedToReserveException("oh no! something went wrong while doing a reservation");
    }

    @Override
    public TicketsBooking fetch(String bookingId) throws BookingNotFoundException {
        return bookingsRepo.findById(bookingId).orElseThrow(() -> new BookingNotFoundException(bookingId));
    }

    private static List<String> generateTickets(int numberOfTickets) {
        return IntStream.of(numberOfTickets).mapToObj(i -> UUID.randomUUID().toString()).toList();
    }

}
