package com.MovieBooking.MovieBooking.exception;

import com.MovieBooking.MovieBooking.exceptions.RegistrationException;
import com.MovieBooking.MovieBooking.exceptions.EmailNotRegisteredException;
import com.MovieBooking.MovieBooking.exceptions.ValidationExpection;
import com.MovieBooking.MovieBooking.exceptions.WrongPasswordExceptionHandker;
import com.MovieBooking.MovieBooking.model.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    ResponseObject responseObject = new ResponseObject();

    @ExceptionHandler(EmailNotRegisteredException.class)
    public ResponseEntity<ResponseObject> handleEmailNotRegistered(EmailNotRegisteredException ex) {
        responseObject.setStatus("400");
        responseObject.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseObject);
    }

    @ExceptionHandler(WrongPasswordExceptionHandker.class)
    public ResponseEntity<ResponseObject> handleWrongPassword(WrongPasswordExceptionHandker ex){
       responseObject.setStatus("400");
       responseObject.setMessage(ex.getMessage());
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseObject);
    }

    @ExceptionHandler(RegistrationException.class)
    public ResponseEntity<ResponseObject> emailAlreadyExists(RegistrationException ex){
        responseObject.setStatus("400");
        responseObject.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseObject);
    }

    @ExceptionHandler(ValidationExpection.class)
    public ResponseEntity<ResponseObject> handleValidationExpection(ValidationExpection ex){
        responseObject.setStatus("400");
        responseObject.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseObject);
    }
}
