package com.example.movieBooking.repository;

import com.example.movieBooking.model.Movie;
import com.example.movieBooking.model.MovieRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long>
{

    String getMovies="\n" +
            "select mov.name as movieName,mov.city,mov.language,mov.genre,ifnull(th.id,0) as theaterId,th.name as theaterName,mov.DESCRIPTION,mov.id as movieId,sh.TIME   from movie mov " +
            "left join show sh on sh.MOVIE_ID=mov.id left join  theatre th on mov.id=th.id";
    @Query(value=getMovies,nativeQuery = true)
    ArrayList getMovies();
}
