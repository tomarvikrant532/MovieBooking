package com.example.movieBooking.model;


import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class ShowRequest {

    private Movie movie;

    private Date date;

    private Time time;
}
