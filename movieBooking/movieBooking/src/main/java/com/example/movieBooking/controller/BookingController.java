package com.example.movieBooking.controller;

import com.example.movieBooking.model.Booking;
import com.example.movieBooking.model.BookingRequest;
import com.example.movieBooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController
{
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking bookTicket(@RequestBody BookingRequest bookingRequest) {
        return bookingService.bookTicket(bookingRequest);
    }

    @PostMapping("/discount")
    public Booking bookTicketWithDiscount(@RequestBody BookingRequest bookingRequest) {
        return bookingService.bookTicketWithDiscount(bookingRequest);
    }

    @PostMapping("/afternoon-discount")
    public Booking bookTicketWithAfternoonDiscount(@RequestBody BookingRequest bookingRequest) {
        return bookingService.bookTicketWithAfternoonDiscount(bookingRequest);
    }

    @PostMapping("/select-seat")
    public Booking bookTicketWithSeatSelection(@RequestBody BookingRequest bookingRequest) {
        return bookingService.bookTicketWithSeatSelection(bookingRequest);
    }

    @PostMapping("/bulk")
    public List<Booking> bookTicketsBulk(@RequestBody List<BookingRequest> bookingRequests) {
        return bookingService.bookTicketsBulk(bookingRequests);
    }

    @DeleteMapping("/bulk")
    public void cancelTicketsBulk(@RequestBody List<Long> bookingIds) {
        bookingService.cancelTicketsBulk(bookingIds);
    }

}
