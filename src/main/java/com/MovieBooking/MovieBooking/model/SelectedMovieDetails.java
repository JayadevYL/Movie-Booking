package com.MovieBooking.MovieBooking.model;


public class SelectedMovieDetails {

    private String movieTheatre;
    private String ticketPrice;

    public SelectedMovieDetails() {
    }

    public SelectedMovieDetails(String movieTheatre, String ticketPrice) {
        this.movieTheatre = movieTheatre;
        this.ticketPrice = ticketPrice;
    }

    public String getMovieTheatre() {
        return movieTheatre;
    }

    public void setMovieTheatre(String movieTheatre) {
        this.movieTheatre = movieTheatre;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "SelectedMovieDetails{" +
                "movieTheatre='" + movieTheatre + '\'' +
                ", ticketPrice='" + ticketPrice + '\'' +
                '}';
    }
}
