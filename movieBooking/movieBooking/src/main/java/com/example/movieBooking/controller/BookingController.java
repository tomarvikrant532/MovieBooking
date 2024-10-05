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

}
