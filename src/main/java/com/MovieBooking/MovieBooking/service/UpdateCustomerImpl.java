package com.MovieBooking.MovieBooking.service;

import com.MovieBooking.MovieBooking.dao.LoginAndRegistrationRepositoryDao;
import com.MovieBooking.MovieBooking.exceptions.RegistrationException;
import com.MovieBooking.MovieBooking.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateCustomerImpl implements UpdateCustomerDetails{
    @Autowired LoginAndRegistrationRepositoryDao loginAndRegistrationRepositoryDao;

    @Override
    @Transactional
    public void updatePassword(UserDetails password) {
        String email= password.getEmail();
        String newPassword= password.getPassword();
        int i=0;

        //Get the older password by using email
       String olderPassword= loginAndRegistrationRepositoryDao.getPasswordForGivenEmail(email);

       if (olderPassword==null){
           throw new RegistrationException("The given Email is not registered");
       }

       if(newPassword.equals(olderPassword)){
         throw new RegistrationException("The given password is current password");
       }
        loginAndRegistrationRepositoryDao.updateThePassword( email, newPassword);
    }
}
