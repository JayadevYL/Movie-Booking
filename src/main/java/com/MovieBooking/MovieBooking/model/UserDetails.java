package com.MovieBooking.MovieBooking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import org.antlr.v4.runtime.misc.NotNull;


public class UserDetails {

    @NotNull
    private String userName;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String phoneNumber;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
