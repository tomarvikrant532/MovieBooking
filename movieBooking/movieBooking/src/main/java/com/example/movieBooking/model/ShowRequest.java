package com.example.movieBooking.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class ShowRequest
{

    @JsonProperty("movie")
    private Movie movie;

    @JsonProperty("date")
    private Date date;

    @JsonProperty("time")
    private Time time;
}
