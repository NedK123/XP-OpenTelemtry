package com.example.booking.api;

import com.example.booking.core.BookTicketsRequest;
import com.example.booking.core.BookingFailedException;
import com.example.booking.core.TicketsBooking;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

public interface BookingApi {

    @PostMapping("")
    ResponseEntity<TicketsBooking> book(BookTicketsRequest request) throws BookingFailedException;

}
