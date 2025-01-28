package com.MovieBooking.MovieBooking.mapper;

import com.MovieBooking.MovieBooking.entity.CustomerHistoryEntity;
import com.MovieBooking.MovieBooking.model.MovieBooking;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-07T17:42:19+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
public class CustomerHistoryMapperImpl implements CustomerHistoryMapper {

    @Override
    public CustomerHistoryEntity toEntity(MovieBooking movieBooking) {
        if ( movieBooking == null ) {
            return null;
        }

        CustomerHistoryEntity customerHistoryEntity = new CustomerHistoryEntity();

        customerHistoryEntity.setMovieName( movieBooking.getMovieName() );
        customerHistoryEntity.setTheatreName( movieBooking.getTheatreName() );
        customerHistoryEntity.setLocation( movieBooking.getLocation() );
        customerHistoryEntity.setTicketPrice( movieBooking.getTicketPrice() );

        return customerHistoryEntity;
    }
}
