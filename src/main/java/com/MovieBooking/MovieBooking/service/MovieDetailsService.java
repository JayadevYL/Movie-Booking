package com.MovieBooking.MovieBooking.service;

import com.MovieBooking.MovieBooking.model.MovieDetails;

import java.util.List;

public interface MovieDetailsService {
    List<String> availableMovieListForSelectedLocation(String location);

}
