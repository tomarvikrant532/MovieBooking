package com.example.movieBooking.repository;

import com.example.movieBooking.model.Show;
import com.example.movieBooking.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {

    List<Show> findByTheatreAndDate(Theatre theatre, Date date);
}
