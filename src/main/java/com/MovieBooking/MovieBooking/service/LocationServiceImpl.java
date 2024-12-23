package com.MovieBooking.MovieBooking.service;

import com.MovieBooking.MovieBooking.dao.LocationRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationRepositoryDao locationRepositoryDao;


    @Override
    public List<String> allTheAvailableLocation() {
        List<String> allTheAvailableLocation=locationRepositoryDao.allTheAvailableLocation();
        return allTheAvailableLocation;
    }
}
