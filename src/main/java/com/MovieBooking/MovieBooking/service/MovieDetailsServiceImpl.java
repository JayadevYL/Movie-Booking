package com.MovieBooking.MovieBooking.service;

import com.MovieBooking.MovieBooking.dao.MovieDetailsDao;
import com.MovieBooking.MovieBooking.model.MovieDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieDetailsServiceImpl implements MovieDetailsService{

    @Autowired MovieDetailsDao movieDetailsDao;

    @Override
    public List<String> availableMovieListForSelectedLocation(String location) {
        return movieDetailsDao.availableMovieListForSelectedLocation(location);
    }
}