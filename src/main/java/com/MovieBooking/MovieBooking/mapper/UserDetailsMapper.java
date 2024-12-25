package com.MovieBooking.MovieBooking.mapper;

import com.MovieBooking.MovieBooking.entity.UserDetailsEntity;
import com.MovieBooking.MovieBooking.model.UserDetails;
import org.apache.catalina.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDetailsMapper {
    UserDetailsMapper INSTANCE = Mappers.getMapper(UserDetailsMapper.class);

    // Map UserDetails to UserDetailsEntity
    UserDetailsEntity toEntity(UserDetails userDetails);

    // Map UserDetailsEntity to UserDetails
    UserDetails toDTO(UserDetailsEntity userDetailsEntity);

}
