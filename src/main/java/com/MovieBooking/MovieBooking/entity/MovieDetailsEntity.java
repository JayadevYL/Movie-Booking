package com.MovieBooking.MovieBooking.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Movie_details")
public class MovieDetailsEntity {

    @Id //primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // This code will auto generate the ID
    @Column(name = "id")
    private int id;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "location")
    private String location;

    @Column(name = "movie_theatre")
    private String movieTheatre;

    @Column(name="ticket_price")
    private String ticketPrice;

    public MovieDetailsEntity() {
    }

    public MovieDetailsEntity(String movieName, String location, String movieTheatre, String ticketPrice) {
        this.movieName = movieName;
        this.location = location;
        this.movieTheatre = movieTheatre;
        this.ticketPrice = ticketPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
        return "MovieBooking{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", location='" + location + '\'' +
                ", movieTheatre='" + movieTheatre + '\'' +
                ", movieTicket='" +ticketPrice + '\'' +
                '}';
    }
}
