package com.example.movieBooking.model;


import lombok.Data;

import java.util.Date;

@Data
public class BookingRequest {

    private Long theatreId;

    private Integer numberOfTickets;

    private Movie movie;

    private Date showTime;

    private String seatNumber;

    private Double price;
}
