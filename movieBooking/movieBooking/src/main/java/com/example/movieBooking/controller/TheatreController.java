package com.example.movieBooking.controller;

import com.example.movieBooking.model.Show;
import com.example.movieBooking.model.ShowRequest;
import com.example.movieBooking.model.Theatre;
import com.example.movieBooking.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/theatres")
public class TheatreController
{
    @Autowired
    private TheatreService theatreService;

    @PostMapping("/onboardTheatre")
    public Theatre createTheatre(@RequestBody Theatre theatre) {
        return theatreService.createTheatre(theatre);
    }

    @PutMapping("/{id}")
    public Theatre updateTheatre(@PathVariable Long id, @RequestBody Theatre theatre) {
        return theatreService.updateTheatre(id, theatre);
    }

    @DeleteMapping("/{id}")
    public void deleteTheatre(@PathVariable Long id) {
        theatreService.deleteTheatre(id);
    }

    @GetMapping("/{movieId}/shows")
    public List<Show> getShows(@PathVariable Long movieId, @RequestParam Date date) {
        return theatreService.getShows(movieId, date);
    }

    @PostMapping("/{id}/shows")
    public Show createShow(@PathVariable Long id, @RequestBody ShowRequest showRequest) {
        return theatreService.createShow(id, showRequest);
    }

    @PutMapping("/{id}/shows/{showId}")
    public Show updateShow(@PathVariable Long id, @PathVariable Long showId, @RequestBody ShowRequest showRequest) {
        return theatreService.updateShow(id, showId, showRequest);
    }

    @DeleteMapping("/{id}/shows/{showId}")
    public void deleteShow(@PathVariable Long id, @PathVariable Long showId) {
        theatreService.deleteShow(id, showId);
    }
}
