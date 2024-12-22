package com.MovieBooking.MovieBooking.dao;

import com.MovieBooking.MovieBooking.entity.MovieBookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieBookingEntity, Integer> {

}
