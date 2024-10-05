package com.example.movieBooking.model;


import lombok.Data;

@Data
public class MovieRequest {

    private String name;

    private String description;

    private String city;

    private int movieId;

    private String language;

    private String genre;

    private int theaterId;

    private String theaterName;

    private String time;
}
