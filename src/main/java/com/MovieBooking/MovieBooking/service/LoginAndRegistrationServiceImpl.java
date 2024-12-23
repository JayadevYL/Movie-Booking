package com.MovieBooking.MovieBooking.service;

import com.MovieBooking.MovieBooking.dao.LoginAndRegistrationRepositoryDao;
import com.MovieBooking.MovieBooking.entity.UserDetailsEntity;
import com.MovieBooking.MovieBooking.exceptions.EmailNotRegisteredException;
import com.MovieBooking.MovieBooking.exceptions.WrongPasswordExceptionHandker;
import com.MovieBooking.MovieBooking.model.Email;
import com.MovieBooking.MovieBooking.model.LoginCredential;
import com.MovieBooking.MovieBooking.model.UserDetails;
import com.MovieBooking.MovieBooking.util.UserDetailsMapperUtil;
import com.MovieBooking.MovieBooking.validations.RegistrationValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class LoginAndRegistrationServiceImpl implements LoginAndRegistrationService{

    @Autowired private LoginAndRegistrationRepositoryDao loginAndRegistrationRepositoryDao;

    @Autowired private Email emailSend;
    @Autowired RegistrationValidations registrationValidations;

    @Override
    @Transactional
    public UserDetails save(UserDetails userDetails) {
        // Convert UserDetails to UserDetailsEntity
        UserDetailsEntity userDetailsEntity = UserDetailsMapperUtil.toEntity(userDetails);

        // Capturing given email and phone number
        String email= userDetails.getEmail();
        String phoneNumber= userDetails.getPhoneNumber();

        // Validation for the given Email and PhoneNumber by calling registrationValidations.class
        registrationValidations.emailValidation(email);
        registrationValidations.checkingTheGivenEmailWithExistingRegisterMail(email);
        registrationValidations.checkingTheGivenPhoneNumberWithExistingRegisterPhoneNumber(phoneNumber);

        // All given data is good to register so Saving the given entity to the database
        UserDetailsEntity savedEntity = loginAndRegistrationRepositoryDao.save(userDetailsEntity);

         String username=userDetails.getUserName();

         //send a mail to registered email
        emailSend.sendMailForRegistration(email, username);

        // Convert saved entity back to UserDetails
        return UserDetailsMapperUtil.toModel(savedEntity);
    }

    @Override
    public String loginVerify(LoginCredential loginCredential) {

        String email=loginCredential.getEmail();

        // Getting password form given email.
        String password=loginAndRegistrationRepositoryDao.getPasswordForGivenEmail(email);

        // If given password is null throwing an exception
        if(password==null){
         throw new EmailNotRegisteredException("Given Email is not registered, Please Register the Email  "+ email);
        }

        // If given password is not correct throwing exception
        if (!Objects.equals(password, loginCredential.getPassword())){
            throw new WrongPasswordExceptionHandker("The given password is not correct, Please give correct password = "+password);
        }
        return "Successfully login";
    }

}
