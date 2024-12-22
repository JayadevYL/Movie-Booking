package com.MovieBooking.MovieBooking.util;

import com.MovieBooking.MovieBooking.entity.UserDetailsEntity;
import com.MovieBooking.MovieBooking.model.UserDetails;

public class UserDetailsMapperUtil {

    public static UserDetailsEntity toEntity(UserDetails userDetails){
        UserDetailsEntity userDetailsEntity = new UserDetailsEntity();
        userDetailsEntity.setEmail(userDetails.getEmail());
        userDetailsEntity.setUserName(userDetails.getUserName());
        userDetailsEntity.setPhoneNumber(userDetails.getPhoneNumber());
        userDetailsEntity.setPassword(userDetails.getPassword());
        return userDetailsEntity;

    }

    public static UserDetails toModel(UserDetailsEntity userDetailsEntity) {
        UserDetails userDetails = new UserDetails();
        userDetails.setEmail(userDetailsEntity.getEmail());
        userDetails.setUserName(userDetailsEntity.getUserName());
        userDetails.setPhoneNumber(userDetailsEntity.getPhoneNumber());
        userDetails.setPassword(userDetailsEntity.getPassword());
        return userDetails;
    }
}
