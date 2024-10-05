package com.example.movieBooking.service;

import com.example.movieBooking.model.Booking;
import com.example.movieBooking.model.BookingRequest;
import com.example.movieBooking.model.Theatre;
import com.example.movieBooking.repository.BookingRepository;
import com.example.movieBooking.repository.MovieRepository;
import com.example.movieBooking.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TheatreRepository theatreRepository;


    @Autowired
    MovieRepository movieRepository;

    public Booking bookTicket(BookingRequest bookingRequest)
    {
        try
        {
            Theatre theatre = theatreRepository.findById(bookingRequest.getTheatreId()).orElseThrow();
            Long count = bookingRepository.countByTheatreAndShowTime(theatre, bookingRequest.getShowTime());
            if (count >= 50) {
                throw new RuntimeException("Seat limit reached for this show");
            }

            Booking booking = new Booking();
            booking.setTheatre(theatre);
            booking.setMovie(movieRepository.findById(Long.parseLong(String.valueOf(bookingRequest.getMovieId()))).orElseThrow());
            booking.setShowTime(bookingRequest.getShowTime());
            booking.setSeatNumber(bookingRequest.getSeatNumber());
            int ticketCount = bookingRequest.getNumberOfTickets();
            double price = bookingRequest.getPrice();
            double discountedPrice = 0;

            for (int i = 1; i <= ticketCount; i++) {
                if (i % 3 == 0) {
                    discountedPrice += price * 0.5; // 50% discount on every third ticket
                } else {
                    discountedPrice += price;
                }
            }

            if (isAfternoon(bookingRequest.getShowTime())) {
                discountedPrice *= 0.8; // 20% discount for afternoon tickets
            }

            booking.setNumberOfTickets(bookingRequest.getNumberOfTickets());
            booking.setPrice(discountedPrice);
            booking.setCustomerId(bookingRequest.getCustomerId());

            return bookingRepository.save(booking);

        }catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }

    }
    private boolean isAfternoon(Date showTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(showTime);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return hour >= 12 && hour < 17; // assuming afternoon is between 12pm and 5pm
    }
}