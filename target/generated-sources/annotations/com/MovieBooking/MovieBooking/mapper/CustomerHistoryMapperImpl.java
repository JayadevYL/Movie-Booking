package com.MovieBooking.MovieBooking.mapper;

import com.MovieBooking.MovieBooking.entity.CustomerHistoryEntity;
import com.MovieBooking.MovieBooking.model.MovieBooking;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-26T14:36:34+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.z20250115-2156, environment: Java 21.0.5 (Eclipse Adoptium)"
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
