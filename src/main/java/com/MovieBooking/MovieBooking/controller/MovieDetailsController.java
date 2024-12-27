package com.MovieBooking.MovieBooking.controller;

import com.MovieBooking.MovieBooking.model.MovieDetails;
import com.MovieBooking.MovieBooking.model.ResponseObject;
import com.MovieBooking.MovieBooking.service.LocationService;
import com.MovieBooking.MovieBooking.service.MovieDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/movie")
public class MovieDetailsController {
    @Autowired LocationService locationService;
    @Autowired MovieDetailsService movieDetailsService;

    @GetMapping("/location")
    public ResponseEntity<List<String>> allTheAvailableLocation(){
        return ResponseEntity.status(HttpStatus.OK).body(locationService.allTheAvailableLocation());
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<String>> availableMoviesForSelectedLocation(@PathVariable String location){
        return ResponseEntity.status(HttpStatus.OK).body(movieDetailsService.availableMovieListForSelectedLocation(location));
    }


}
