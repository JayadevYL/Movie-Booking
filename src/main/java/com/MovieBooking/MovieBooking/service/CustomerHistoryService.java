package com.MovieBooking.MovieBooking.service;

import com.MovieBooking.MovieBooking.model.MovieBooking;

import java.util.List;

public interface CustomerHistoryService {

    void saveTheMovieBookingDetailsToCustomerHistoryDB(MovieBooking movieBooking);
}
