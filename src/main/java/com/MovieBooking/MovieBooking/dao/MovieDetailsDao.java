package com.MovieBooking.MovieBooking.dao;

import com.MovieBooking.MovieBooking.entity.MovieDetailsEntity;
import com.MovieBooking.MovieBooking.model.MovieDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieDetailsDao extends JpaRepository<MovieDetailsEntity, Integer > {

    @Query("SELECT m.movieName FROM MovieDetailsEntity m WHERE m.location=:location")
    List<String> availableMovieListForSelectedLocation(@Param("location") String location);
}
