package com.example.booking.api;

import com.example.booking.core.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@AllArgsConstructor
@Slf4j
public class BookingController implements BookingApi {

    private BookingService bookingService;

    @Override
    public ResponseEntity<TicketsBooking> book(BookTicketsRequest request) throws BookingFailedException {
        log.info("Received a booking request={}", request);
        TicketsBooking booking = bookingService.book(request);
        return ResponseEntity.created(bookingLocation(booking)).build();
    }

    @Override
    public ResponseEntity<TicketsBooking> get(String bookingId) throws BookingNotFoundException {
        TicketsBooking booking = bookingService.get(bookingId);
        return ResponseEntity.ok(booking);
    }

    private static URI bookingLocation(TicketsBooking booking) {
        return URI.create("/" + booking.getId());
    }

    @ExceptionHandler(value = BookingFailedException.class)
    public ResponseEntity<TicketsBooking> handleBookingFailedException(BookingFailedException exception) {
        return ResponseEntity.notFound().build();
    }


}
