package com.example.movieBooking.model;


import lombok.Data;

@Data
public class MovieRequest {

    private String name;

    private String description;

    private String city;

    private String language;

    private String genre;
}
