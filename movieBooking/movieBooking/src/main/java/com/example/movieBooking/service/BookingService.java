package com.example.movieBooking.service;

import com.example.movieBooking.model.Booking;
import com.example.movieBooking.model.BookingRequest;
import com.example.movieBooking.model.Theatre;
import com.example.movieBooking.repository.BookingRepository;
import com.example.movieBooking.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    public Booking bookTicket(BookingRequest bookingRequest) {
        Theatre theatre = theatreRepository.findById(bookingRequest.getTheatreId()).orElseThrow();
        Booking booking = new Booking();
        booking.setTheatre(theatre);
        booking.setMovie(bookingRequest.getMovie());
        booking.setShowTime(bookingRequest.getShowTime());
        booking.setSeatNumber(bookingRequest.getSeatNumber());
        Double price = bookingRequest.getPrice();
        if (bookingRequest.getNumberOfTickets() >= 3) {
            price = price * 0.5;
        }
        booking.setPrice(price);
        return bookingRepository.save(booking);
    }

    public Booking bookTicketWithDiscount(BookingRequest bookingRequest) {
        Theatre theatre = theatreRepository.findById(bookingRequest.getTheatreId()).orElseThrow();
        Booking booking = new Booking();
        booking.setTheatre(theatre);
        booking.setMovie(bookingRequest.getMovie());
        booking.setShowTime(bookingRequest.getShowTime());
        booking.setSeatNumber(bookingRequest.getSeatNumber());
        Double price = bookingRequest.getPrice();
        if (bookingRequest.getNumberOfTickets() >= 3) {
            price = price * 0.5;
        }
        else if (bookingRequest.getShowTime().getHours() >= 12 && bookingRequest.getShowTime().getHours() < 18) {
            price = price * 0.8;
        }
        booking.setPrice(price);
        return bookingRepository.save(booking);
    }

    public Booking bookTicketWithAfternoonDiscount(BookingRequest bookingRequest) {
        Theatre theatre = theatreRepository.findById(bookingRequest.getTheatreId()).orElseThrow();
        Booking booking = new Booking();
        booking.setTheatre(theatre);
        booking.setMovie(bookingRequest.getMovie());
        booking.setShowTime(bookingRequest.getShowTime());
        booking.setSeatNumber(bookingRequest.getSeatNumber());
        Double price = bookingRequest.getPrice();
        if (bookingRequest.getShowTime().getHours() >= 12 && bookingRequest.getShowTime().getHours() < 18) {
            price = price * 0.8;
        }
        booking.setPrice(price);
        return bookingRepository.save(booking);
    }

    public Booking bookTicketWithSeatSelection(BookingRequest bookingRequest) {
        Theatre theatre = theatreRepository.findById(bookingRequest.getTheatreId()).orElseThrow();
        Booking booking = new Booking();
        booking.setTheatre(theatre);
        booking.setMovie(bookingRequest.getMovie());
        booking.setShowTime(bookingRequest.getShowTime());
        booking.setSeatNumber(bookingRequest.getSeatNumber());
        booking.setPrice(bookingRequest.getPrice());
        return bookingRepository.save(booking);
    }

    public List<Booking> bookTicketsBulk(List<BookingRequest> bookingRequests) {
        List<Booking> bookings = new ArrayList<>();
        for (BookingRequest bookingRequest : bookingRequests) {
            bookings.add(bookTicket(bookingRequest));
        }
        return bookings;
    }

    public void cancelTicketsBulk(List<Long> bookingIds) {
        for (Long bookingId : bookingIds) {
            bookingRepository.deleteById(bookingId);
        }
    }
}