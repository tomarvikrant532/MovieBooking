package com.example.movieBooking.service;

import com.example.movieBooking.model.Seat;
import com.example.movieBooking.model.SeatRequest;
import com.example.movieBooking.model.Show;
import com.example.movieBooking.repository.SeatRepository;
import com.example.movieBooking.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private SeatRepository seatRepository;

    public Seat allocateSeat(Long id, SeatRequest seatRequest) {
        Show show = showRepository.findById(id).orElseThrow();
        Seat seat = new Seat();
        seat.setShow(show);
        seat.setSeatNumber(seatRequest.getSeatNumber());
        seat.setSeatType(seatRequest.getSeatType());
        return seatRepository.save(seat);
    }

    public Seat updateSeat(Long id, Long seatId, SeatRequest seatRequest) {
        Show show = showRepository.findById(id).orElseThrow();
        Seat seat = seatRepository.findById(seatId).orElseThrow();
        seat.setSeatNumber(seatRequest.getSeatNumber());
        seat.setSeatType(seatRequest.getSeatType());
        return seatRepository.save(seat);
    }

    public void deleteSeat(Long id, Long seatId) {
        seatRepository.deleteById(seatId);
    }
}
