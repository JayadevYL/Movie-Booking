package com.MovieBooking.MovieBooking.dao;

import com.MovieBooking.MovieBooking.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepositoryDao extends JpaRepository<LocationEntity, Integer> {
}

