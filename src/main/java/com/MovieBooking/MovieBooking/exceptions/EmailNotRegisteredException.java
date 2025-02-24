package com.MovieBooking.MovieBooking.exceptions;

public class EmailNotRegisteredException extends RuntimeException{

    public EmailNotRegisteredException(String message)  {
        super(message);  // Pass message to the parent class (RuntimeException)
    }
}
