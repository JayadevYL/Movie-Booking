package com.MovieBooking.MovieBooking.service;

import com.MovieBooking.MovieBooking.model.MovieBooking;
import com.MovieBooking.MovieBooking.model.MovieBookingRequest;

import java.util.List;

public interface CustomerHistoryService {

    void saveTheMovieBookingDetailsToCustomerHistoryDB(MovieBooking movieBooking);

    void directlyBookMovieTicketWithAllTheVerification(MovieBookingRequest bookingDetails);
}
