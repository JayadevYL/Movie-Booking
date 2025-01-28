package com.MovieBooking.MovieBooking.mapper;


import com.MovieBooking.MovieBooking.entity.CustomerHistoryEntity;
import com.MovieBooking.MovieBooking.model.MovieBooking;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerHistoryMapper {
    CustomerHistoryMapper INSTANCE= Mappers.getMapper(CustomerHistoryMapper.class);

    CustomerHistoryEntity toEntity(MovieBooking movieBooking);

    }
