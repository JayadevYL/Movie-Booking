package com.MovieBooking.MovieBooking.controller;

import com.MovieBooking.MovieBooking.model.*;
import com.MovieBooking.MovieBooking.service.CustomerHistoryService;
import com.MovieBooking.MovieBooking.service.CustomerHistoryServiceImpl;
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
    @Autowired CustomerHistoryService customerHistoryService;
    @Autowired private ResponseObject responseObject;


    //This API for location, where user will see  all the location
    @GetMapping("/location")
    public ResponseEntity<List<String>> allTheAvailableLocation(){
        return ResponseEntity.status(HttpStatus.OK).body(locationService.allTheAvailableLocation());
    }

    //This API will get all available movie details for selected location
    @GetMapping("/location/{location}")
    public ResponseEntity<List<String>> availableMoviesForSelectedLocation(@PathVariable String location){
        return ResponseEntity.status(HttpStatus.OK).body(movieDetailsService.availableMovieListForSelectedLocation(location));
    }

    //This API will give movie details for selected movie
    @GetMapping("/location/movie/{movie}")
    public ResponseEntity<List<SelectedMovieDetails>> selectedMovieDetails(@PathVariable String movie){
        return ResponseEntity.status(HttpStatus.OK).body( movieDetailsService.movieDetailsForSelectedMovie(movie));
    }

    //This API for booking Movie ticket
    @PostMapping("/book/movie")
    public ResponseEntity<?> bookMovie(@RequestBody MovieBooking movieBooking)
    {
        customerHistoryService.saveTheMovieBookingDetailsToCustomerHistoryDB(movieBooking);
        responseObject.setStatus("200");
        responseObject.setMessage("movie is successfully booked");
        return ResponseEntity.status(HttpStatus.OK).body(responseObject);
    }

    @PostMapping("/direct/booking")
    public ResponseEntity<?> bookingdirectly(@RequestBody MovieBookingRequest bookingDetails){
        customerHistoryService.directlyBookMovieTicketWithAllTheVerification(bookingDetails);
        return ResponseEntity.status(HttpStatus.OK).body("Movie ticket is booked, Thank you for booking enjoy your time");
    }



}
