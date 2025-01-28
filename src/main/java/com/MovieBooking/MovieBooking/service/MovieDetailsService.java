package com.MovieBooking.MovieBooking.service;

import com.MovieBooking.MovieBooking.model.MovieDetails;
import com.MovieBooking.MovieBooking.model.SelectedMovieDetails;

import java.util.List;

public interface MovieDetailsService {
    List<String> availableMovieListForSelectedLocation(String location);
    List<SelectedMovieDetails> movieDetailsForSelectedMovie(String movie);

}
