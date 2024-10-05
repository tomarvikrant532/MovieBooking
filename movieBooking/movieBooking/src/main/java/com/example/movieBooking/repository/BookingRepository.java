package com.example.movieBooking.repository;

import com.example.movieBooking.model.Booking;
import com.example.movieBooking.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface BookingRepository extends JpaRepository<Booking, Long>
{
    Long countByCustomerId(int customerId);

    Long countByTheatreAndShowTime(Theatre theatre, Date showTime);

}
