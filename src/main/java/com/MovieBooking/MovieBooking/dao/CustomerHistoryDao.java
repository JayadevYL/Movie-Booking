package com.MovieBooking.MovieBooking.dao;

import com.MovieBooking.MovieBooking.entity.CustomerHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerHistoryDao extends JpaRepository<CustomerHistoryEntity, Integer> {

}
