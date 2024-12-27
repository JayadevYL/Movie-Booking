package com.MovieBooking.MovieBooking.model;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResponseObject {

    String status;
    String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
