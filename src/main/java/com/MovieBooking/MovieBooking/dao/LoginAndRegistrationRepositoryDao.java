package com.MovieBooking.MovieBooking.dao;

import com.MovieBooking.MovieBooking.entity.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoginAndRegistrationRepositoryDao extends JpaRepository<UserDetailsEntity, Integer> {

   @Query("SELECT u.password FROM UserDetailsEntity u WHERE u.email=:email")
   String getPasswordForGivenEmail(@Param("email") String email);

   @Query("SELECT u.email FROM UserDetailsEntity u")
   List<String> getEmailId();

   @Query("SELECT u.phoneNumber FROM UserDetailsEntity u")
   List<String> getPhoneNumber();

}
