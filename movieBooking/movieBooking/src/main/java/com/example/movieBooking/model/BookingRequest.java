package com.example.movieBooking.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Time;
import java.util.Date;


@Data
public class BookingRequest {

    @JsonProperty("theatreId")
    private Long theatreId;

    @JsonProperty("numberOfTickets")
    private Integer numberOfTickets;

    @JsonProperty("movieId")
    private int movieId;

    @JsonProperty("showTime")
    private Time showTime;

    @JsonProperty("seatNumber")
    private String seatNumber;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("customerId")
    private int customerId;
}