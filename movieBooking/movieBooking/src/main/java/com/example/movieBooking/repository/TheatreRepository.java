package com.example.movieBooking.repository;

import com.example.movieBooking.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    @Query("SELECT t FROM Theatre t JOIN t.shows s WHERE s.movie.id = :movieId")
    List<Theatre> findByMovieId(@Param("movieId") Long movieId);
}
