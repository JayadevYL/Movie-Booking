package com.MovieBooking.MovieBooking.service;

import com.MovieBooking.MovieBooking.model.LoginCredential;
import com.MovieBooking.MovieBooking.model.UserDetails;

public interface LoginAndRegistrationService {

    UserDetails save(UserDetails userDetails);
    String loginVerify(LoginCredential loginCredential);
}
