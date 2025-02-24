package com.MovieBooking.MovieBooking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MovieDetail {

    @JsonProperty("movieName")
    String movieName;
    @JsonProperty("location")
    String location;
    @JsonProperty("movieTheatre")
    String movieTheatre;
    @JsonProperty("ticketPrice")
    int ticketPrice;
}
