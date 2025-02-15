package com.MovieBooking.MovieBooking.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="customer_history")
public class CustomerHistoryEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="customer_id")
    private String customerId;

    @Column(name="movie_name")
    private String movieName;

    @Column(name="theatre_name")
    private String theatreName;

    @Column(name="location")
    private  String location;

    @Column(name="price")
    private int ticketPrice;


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "CustomerHistory{" +
                "id=" + id +
                "customerId='" + customerId + '\'' +
                ", movieName='" + movieName + '\'' +
                ", theatreName='" + theatreName + '\'' +
                ", location='" + location + '\'' +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
