package org.example.pricing.adapters;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.pricing.core.booking.Booking;
import org.example.pricing.core.booking.BookingNotFoundException;
import org.example.pricing.core.booking.BookingService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class BookingAdapter implements BookingService {

    private BookingServiceFeignClient client;

    @Override
    public Booking fetch(String bookingId) throws BookingNotFoundException {
        return client.get(bookingId).getBody();
    }

}
