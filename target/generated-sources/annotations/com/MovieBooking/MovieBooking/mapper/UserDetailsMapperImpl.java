package com.MovieBooking.MovieBooking.mapper;

import com.MovieBooking.MovieBooking.entity.UserDetailsEntity;
import com.MovieBooking.MovieBooking.model.UserDetails;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-26T14:36:34+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.z20250115-2156, environment: Java 21.0.5 (Eclipse Adoptium)"
)
public class UserDetailsMapperImpl implements UserDetailsMapper {

    @Override
    public UserDetailsEntity toEntity(UserDetails userDetails) {
        if ( userDetails == null ) {
            return null;
        }

        UserDetailsEntity userDetailsEntity = new UserDetailsEntity();

        userDetailsEntity.setUserName( userDetails.getUserName() );
        userDetailsEntity.setEmail( userDetails.getEmail() );
        userDetailsEntity.setPassword( userDetails.getPassword() );
        userDetailsEntity.setPhoneNumber( userDetails.getPhoneNumber() );

        return userDetailsEntity;
    }

    @Override
    public UserDetails toModel(UserDetailsEntity userDetailsEntity) {
        if ( userDetailsEntity == null ) {
            return null;
        }

        UserDetails userDetails = new UserDetails();

        userDetails.setUserName( userDetailsEntity.getUserName() );
        userDetails.setEmail( userDetailsEntity.getEmail() );
        userDetails.setPassword( userDetailsEntity.getPassword() );
        userDetails.setPhoneNumber( userDetailsEntity.getPhoneNumber() );

        return userDetails;
    }
}
