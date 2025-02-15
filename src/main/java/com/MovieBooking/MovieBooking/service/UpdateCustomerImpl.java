package com.MovieBooking.MovieBooking.service;

import com.MovieBooking.MovieBooking.dao.CustomerHistoryDao;
import com.MovieBooking.MovieBooking.dao.LoginAndRegistrationRepositoryDao;
import com.MovieBooking.MovieBooking.exceptions.RegistrationException;
import com.MovieBooking.MovieBooking.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateCustomerImpl implements UpdateCustomerDetails{
    @Autowired LoginAndRegistrationRepositoryDao loginAndRegistrationRepositoryDao;
    @Autowired CustomerHistoryDao customerHistoryDao;

    @Override
    @Transactional
    public void updatePassword(UserDetails password) {
        String email= password.getEmail();
        String newPassword= password.getPassword();


        //Get the older password by using email
       String olderPassword= loginAndRegistrationRepositoryDao.getPasswordForGivenEmail(email);

        // If the given Email is not registered
        if (olderPassword==null){
           throw new RegistrationException("The given Email is not registered");
       }

        //If the given few password is same as older password
        if(newPassword.equals(olderPassword)){
         throw new RegistrationException("The given password is current password");
       }
        //updating the customer
        loginAndRegistrationRepositoryDao.updateThePassword( email, newPassword);
    }

    @Override
    @Transactional
    public void deleteTheCustomer(UserDetails deleteCustomer) {

        //capturing email
        String email=deleteCustomer.getEmail();
        //capturing new password
        String password= deleteCustomer.getPassword();


        // Taking older password using email
       String customerEmail= loginAndRegistrationRepositoryDao.getPasswordForGivenEmail(email);

        // If the given Email is not registered
        if (customerEmail==null){
            throw new RegistrationException("Given Email is not registered");
        }
        //If the given few password is same as older password
        if(!loginAndRegistrationRepositoryDao.getPasswordForGivenEmail(email).equals(password)) {
            throw new RegistrationException("Password is not correct.Please enter valid password");
        }

        //Capturing customerID
        String customerId= loginAndRegistrationRepositoryDao.getCustomerId(email);

        //Using customerId deleting all the record from history DB
        customerHistoryDao.deleteByCustomerId(customerId);


        // deleting the customer from DB
        loginAndRegistrationRepositoryDao.deleteByEmail(email);
    }
}
