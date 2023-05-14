package com.example.booking.core;

import org.springframework.stereotype.Service;

@Service
public interface BookingService {

    TicketsBooking book(BookTicketsRequest request) throws BookingFailedException;

}
