package com.MovieBooking.MovieBooking.service;

import com.MovieBooking.MovieBooking.dao.CustomerHistoryDao;
import com.MovieBooking.MovieBooking.dao.LoginAndRegistrationRepositoryDao;
import com.MovieBooking.MovieBooking.entity.CustomerHistoryEntity;
import com.MovieBooking.MovieBooking.mapper.CustomerHistoryMapper;
import com.MovieBooking.MovieBooking.model.MovieBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerHistoryServiceImpl implements CustomerHistoryService{

    @Autowired CustomerHistoryDao customerHistoryDao;
    @Autowired LoginAndRegistrationRepositoryDao loginAndRegistrationRepositoryDao;

    @Override
    @Transactional
    public void saveTheMovieBookingDetailsToCustomerHistoryDB(MovieBooking movieBooking) {

        //Convert MovieBooking object to CustomerHistory object to save DB
        CustomerHistoryEntity customerHistoryEntity= CustomerHistoryMapper.INSTANCE.toEntity(movieBooking);

        //Using Email getting customerID and set it
       String email= movieBooking.getEmail();
       String customerID=loginAndRegistrationRepositoryDao.getCustomerId(email);
       customerHistoryEntity.setCustomerId(customerID);

        //Save to DB
        customerHistoryDao.save(customerHistoryEntity);
    }
}
