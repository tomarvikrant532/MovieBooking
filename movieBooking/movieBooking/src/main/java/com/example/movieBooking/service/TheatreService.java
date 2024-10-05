package com.example.movieBooking.service;

import com.example.movieBooking.model.Movie;
import com.example.movieBooking.model.Show;
import com.example.movieBooking.model.ShowRequest;
import com.example.movieBooking.model.Theatre;
import com.example.movieBooking.repository.MovieRepository;
import com.example.movieBooking.repository.ShowRepository;
import com.example.movieBooking.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    MovieRepository movieRepository;


    @Transactional
    public Theatre createTheatre(Theatre theatre) {
        return theatreRepository.saveAndFlush(theatre);
    }

    public Theatre updateTheatre(Long id, Theatre theatre) {
        Theatre existingTheatre = theatreRepository.findById(id).orElseThrow();
        existingTheatre.setName(theatre.getName());
        existingTheatre.setAddress(theatre.getAddress());
        return theatreRepository.save(existingTheatre);
    }

    public void deleteTheatre(Long id) {
        theatreRepository.deleteById(id);
    }

    public List<Show> getShows(Long movieId, Date date) {
        List<Theatre> theatres = theatreRepository.findByMovieId(movieId);
        List<Show> shows = new ArrayList<>();
        for (Theatre theatre : theatres) {
            shows.addAll(showRepository.findByTheatreAndDate(theatre, date));
        }
        return shows;
    }

    public Show createShow(Long id, ShowRequest showRequest) {
        try {
            Theatre theatre = theatreRepository.findById(id).orElseThrow(() -> new RuntimeException("Theater id not present"));
            Movie newMovie = new Movie();
            newMovie.setName(showRequest.getMovie().getName());
            newMovie.setDescription(showRequest.getMovie().getDescription());
            newMovie.setCity(showRequest.getMovie().getCity());
            newMovie.setLanguage(showRequest.getMovie().getLanguage());
            newMovie.setGenre(showRequest.getMovie().getGenre());
            movieRepository.save(newMovie);
            Show show = new Show();
            show.setTheatre(theatre);
            show.setMovie(newMovie);
            show.setDate(showRequest.getDate());
            show.setTime(showRequest.getTime());
            return showRepository.save(show);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public Show updateShow(Long id, Long showId, ShowRequest showRequest) {
        Theatre theatre = theatreRepository.findById(id).orElseThrow();
        Show show = showRepository.findById(showId).orElseThrow();
        show.setMovie(showRequest.getMovie());
        show.setDate(showRequest.getDate());
        show.setTime(showRequest.getTime());
        return showRepository.save(show);
    }

    public void deleteShow(Long id, Long showId) {
        showRepository.deleteById(showId);
    }
}

