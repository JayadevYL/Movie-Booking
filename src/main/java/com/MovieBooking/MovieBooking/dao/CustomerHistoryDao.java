package com.MovieBooking.MovieBooking.dao;

import com.MovieBooking.MovieBooking.entity.CustomerHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface CustomerHistoryDao extends JpaRepository<CustomerHistoryEntity, Integer> {

    @Modifying
    @Query("DELETE CustomerHistoryEntity u WHERE u.customerId = :customerId")
    void deleteByCustomerId(String customerId);
}
