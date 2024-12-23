package com.MovieBooking.MovieBooking.controller;

import com.MovieBooking.MovieBooking.model.ResponseObject;
import com.MovieBooking.MovieBooking.service.LocationService;
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

    @GetMapping("/location")
    public ResponseEntity<List<String>> allTheAvailableLocation(){
        return ResponseEntity.status(HttpStatus.OK).body(locationService.allTheAvailableLocation());
    }

}
