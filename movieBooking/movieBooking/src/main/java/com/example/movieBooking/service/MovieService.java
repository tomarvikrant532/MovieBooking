package com.example.movieBooking.service;

import com.example.movieBooking.model.Movie;
import com.example.movieBooking.model.MovieRequest;
import com.example.movieBooking.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<MovieRequest> getMovies() {
        ArrayList arr= movieRepository.getMovies();
        Iterator itr=arr.iterator();
        List<MovieRequest> movieList=new ArrayList<>();
        while(itr.hasNext())
        {
            Object[] ob= (Object[]) itr.next();
            MovieRequest movieRequest=new MovieRequest();
            movieRequest.setName((String) ob[0]);
            movieRequest.setCity((String) ob[1]);
            movieRequest.setLanguage((String) ob[2]);
            movieRequest.setGenre((String) ob[3]);
            movieRequest.setTheaterId(Integer.parseInt(String.valueOf(ob[4])));
            movieRequest.setTheaterName(String.valueOf(ob[5]));
            movieRequest.setDescription(String.valueOf(ob[6]));
            movieRequest.setMovieId(Integer.parseInt(String.valueOf(ob[7])));
            movieRequest.setTime(String.valueOf(ob[8]));
            movieList.add(movieRequest);
        }
        return movieList;
    }

    public Movie getMovie(Long id) {
        return movieRepository.findById(id).orElseThrow();
    }
}
