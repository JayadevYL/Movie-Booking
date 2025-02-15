package com.MovieBooking.MovieBooking.service;

import com.MovieBooking.MovieBooking.model.UserDetails;

public interface UpdateCustomerDetails {
    void updatePassword(UserDetails password);

    void deleteTheCustomer(UserDetails deleteCustomer);
}
