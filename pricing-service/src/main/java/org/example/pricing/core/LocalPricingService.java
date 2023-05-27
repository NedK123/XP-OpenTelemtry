package org.example.pricing.core;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.pricing.core.booking.Booking;
import org.example.pricing.core.booking.BookingNotFoundException;
import org.example.pricing.core.booking.BookingService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class LocalPricingService implements PricingService {

    private BookingService bookingService;
    private EventTicketsPriceStorage storage;

    @Override
    public BookingPrice calculatePrice(String bookingId) throws FailedToPriceBookingException {
        Booking booking = fetchBooking(bookingId);
        log.info("Fetched booking({}) info for price quotation. {}", booking.getId(), booking);
        return generatePrice(booking);
    }

    @Override
    public void registerTicketsPrice(RegisterTicketsPricesRequest request) {
        log.info("registering tickets prices {}", request);
        storage.save(request);
    }

    private BookingPrice generatePrice(Booking booking) throws FailedToPriceBookingException {
        TicketPrice ticketPrice = fetchTicketPrice(booking);
        log.info("Fetched ticket price {} for booking={}", ticketPrice, booking.getId());
        double finalPrice = booking.getTicketsIds().stream().mapToDouble(s -> ticketPrice.getAmount()).reduce((left, right) -> left + right).orElseThrow(FailedToPriceBookingException::new);
        log.info("Quoted a total booking price of {} for booking {}", finalPrice, booking.getId());
        return BookingPrice.builder().amount(finalPrice).currency(ticketPrice.getCurrency()).build();
    }

    private TicketPrice fetchTicketPrice(Booking booking) throws FailedToPriceBookingException {
        try {
            return storage.fetch(booking.getEventId(), booking.getAreaId());
        } catch (TicketPriceNotFoundException e) {
            log.error("An error occured while fetching ticket prices for booking={}", booking, e);
            throw new FailedToPriceBookingException();
        }
    }

    private Booking fetchBooking(String bookingId) throws FailedToPriceBookingException {
        try {
            return bookingService.fetch(bookingId);
        } catch (BookingNotFoundException e) {
            throw new FailedToPriceBookingException();
        }
    }

}
