package com.MovieBooking.MovieBooking.service;

import com.MovieBooking.MovieBooking.model.MovieDetails;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LocationService {

    List<String> allTheAvailableLocation();
}
