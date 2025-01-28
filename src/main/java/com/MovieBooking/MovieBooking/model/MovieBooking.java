package com.MovieBooking.MovieBooking.model;

public class MovieBooking {

    private String movieName;
    private String location;
    private String theatreName;
    private int ticketPrice;
    private  String email;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getEmail() {
        return email;
    }

    public void setEmailId(String emailId) {
        this.email = emailId;
    }

    @Override
    public String toString() {
        return "MovieBooking{" +
                ", movieName='" + movieName + '\'' +
                ", location='" + location + '\'' +
                ", theatreName='" + theatreName + '\'' +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
