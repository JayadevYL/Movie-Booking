package com.MovieBooking.MovieBooking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class CustomerDetails {

    @JsonProperty("userName")
    String userName;
    @JsonProperty("email")
    String email;
}
