package com.MovieBooking.MovieBooking.service;

import com.MovieBooking.MovieBooking.dao.CustomerHistoryDao;
import com.MovieBooking.MovieBooking.dao.LoginAndRegistrationRepositoryDao;
import com.MovieBooking.MovieBooking.entity.CustomerHistoryEntity;
import com.MovieBooking.MovieBooking.exceptions.ValidationExpection;
import com.MovieBooking.MovieBooking.mapper.CustomerHistoryMapper;
import com.MovieBooking.MovieBooking.model.CustomerDetails;
import com.MovieBooking.MovieBooking.model.MovieBooking;
import com.MovieBooking.MovieBooking.model.MovieBookingRequest;
import com.MovieBooking.MovieBooking.model.MovieDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

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

    @Override
    @Transactional
    public void directlyBookMovieTicketWithAllTheVerification(MovieBookingRequest bookingDetails) {
        try {
            //Get customer from bookingDetails
           String bookingDetailsCustomerId =bookingDetails.getCustomerId();

           //Check Given customerId present in DB
            Optional.ofNullable(bookingDetailsCustomerId)
                    .filter(loginAndRegistrationRepositoryDao::existsByCustomerId)
                    .orElseThrow(()->new ValidationExpection("Given CustomerId is not correct Please provide Validate customerId"));

            //Get Email from bookingDetails
            String email = Optional.ofNullable(bookingDetails.getCustomerDetails())
                    .orElseThrow(() -> new ValidationExpection("Customer details list is missing!"))
                    .stream()
                    .map(CustomerDetails::getEmail)
                    .filter(Objects::nonNull) // Removes null emails
                    .findFirst()
                    .orElseThrow(() -> new ValidationExpection("Email is missing!"));

            //Using email get customerID
            String dbCustomerId=Optional.ofNullable(loginAndRegistrationRepositoryDao.getCustomerId(email))
                    .orElseThrow(()->new ValidationExpection("Given Email is not correct"));

            //Check bookingDetailsCustomerId and dbCustomerId
            if(!bookingDetailsCustomerId.equals(dbCustomerId)){
                throw new ValidationExpection("Given CustomerId and Email is not matching please provide correct details");
            }

            //Get movie location in bookingDerails
            String bookingDetailsLocation=Optional.ofNullable(bookingDetails.getMovieDetails())
                    .orElseThrow(()-> new ValidationExpection("Movie Details is mandatory"))
                    .stream().map(MovieDetail::getLocation)
                    .filter(Objects::nonNull)
                    .filter(location -> !location.trim().isEmpty())// Removes null locations
                    .findFirst()
                    .orElseThrow(()->new ValidationExpection("Location can not be empty or null"));


        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }


}
