package com.example.movieBooking.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String city;

    private String language;

    private String genre;
}
