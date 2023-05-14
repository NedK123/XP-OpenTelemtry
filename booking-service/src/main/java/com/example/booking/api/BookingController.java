package com.example.booking.api;

import com.example.booking.core.BookTicketsRequest;
import com.example.booking.core.BookingFailedException;
import com.example.booking.core.BookingService;
import com.example.booking.core.TicketsBooking;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@AllArgsConstructor
public class BookingController implements BookingApi {

    private BookingService bookingService;

    @Override
    public ResponseEntity<TicketsBooking> book(BookTicketsRequest request) throws BookingFailedException {
        TicketsBooking booking = bookingService.book(request);
        return ResponseEntity.created(bookingLocation(booking)).build();
    }

    private static URI bookingLocation(TicketsBooking booking) {
        return URI.create("/" + booking.getBookingId());
    }

    @ExceptionHandler(value = BookingFailedException.class)
    public ResponseEntity<TicketsBooking> handleBookingFailedException(BookingFailedException exception) {
        return ResponseEntity.notFound().build();
    }


}
