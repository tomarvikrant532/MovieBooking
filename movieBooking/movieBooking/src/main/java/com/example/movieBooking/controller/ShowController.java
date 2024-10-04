package com.example.movieBooking.controller;

import com.example.movieBooking.model.Seat;
import com.example.movieBooking.model.SeatRequest;
import com.example.movieBooking.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/{id}/seats")
    public Seat allocateSeat(@PathVariable Long id, @RequestBody SeatRequest seatRequest) {
        return showService.allocateSeat(id, seatRequest);
    }

    @PutMapping("/{id}/seats/{seatId}")
    public Seat updateSeat(@PathVariable Long id, @PathVariable Long seatId, @RequestBody SeatRequest seatRequest) {
        return showService.updateSeat(id, seatId, seatRequest);
    }

    @DeleteMapping("/{id}/seats/{seatId}")
    public void deleteSeat(@PathVariable Long id, @PathVariable Long seatId) {
        showService.deleteSeat(id, seatId);
    }
}
