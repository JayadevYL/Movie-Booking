package com.MovieBooking.MovieBooking.exceptions;

public class WrongPasswordExceptionHandker extends RuntimeException {

    public WrongPasswordExceptionHandker(String message) {
        super(message);
    }
}
