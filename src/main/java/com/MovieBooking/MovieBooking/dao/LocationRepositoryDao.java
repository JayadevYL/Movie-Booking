package com.MovieBooking.MovieBooking.dao;

import com.MovieBooking.MovieBooking.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Objects;

public interface LocationRepositoryDao extends JpaRepository<LocationEntity, Integer> {

    @Query("SELECT l.city FROM LocationEntity l")
    List<String> allTheAvailableLocation();
}

