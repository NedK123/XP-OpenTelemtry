package com.example.booking.api;

import com.example.booking.core.BookTicketsRequest;
import com.example.booking.core.BookingFailedException;
import com.example.booking.core.BookingNotFoundException;
import com.example.booking.core.TicketsBooking;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("booking/")
public interface BookingApi {

    @PostMapping("")
    ResponseEntity<TicketsBooking> book(BookTicketsRequest request) throws BookingFailedException;

    @GetMapping("{id}")
    ResponseEntity<TicketsBooking> get(@PathVariable("id") String bookingId) throws BookingNotFoundException;

}
