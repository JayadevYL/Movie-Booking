package com.MovieBooking.MovieBooking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class MovieBookingRequest {

    @JsonProperty("customerID")
    String customerId;
    @JsonProperty("customerDetails")
    List<CustomerDetails> customerDetails;
    @JsonProperty("movieDetails")
    List<MovieDetail> movieDetails;
}
