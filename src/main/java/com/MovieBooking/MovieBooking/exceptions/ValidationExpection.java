package com.MovieBooking.MovieBooking.exceptions;

public class ValidationExpection extends RuntimeException{
    public ValidationExpection(String message) {
        super(message);
    }
}
