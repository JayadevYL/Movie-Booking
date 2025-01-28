package com.MovieBooking.MovieBooking.dao;

import com.MovieBooking.MovieBooking.entity.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface LoginAndRegistrationRepositoryDao extends JpaRepository<UserDetailsEntity, Integer> {

   @Query("SELECT u.password FROM UserDetailsEntity u WHERE u.email=:email")
   String getPasswordForGivenEmail(@Param("email") String email);

   @Query("SELECT u.email FROM UserDetailsEntity u")
   List<String> getEmailId();

   @Query("SELECT u.phoneNumber FROM UserDetailsEntity u")
   List<String> getPhoneNumber();

   @Query("SELECT u.customerId FROM UserDetailsEntity u WHERE u.email=:email ")
   String getCustomerId(@Param("email") String email);

//   UserDetailsEntity findByUserName(String username);

   @Modifying
   @Query("UPDATE UserDetailsEntity u SET u.password = :newPassword WHERE u.email = :email")
   void updateThePassword(String email, String newPassword);
}
