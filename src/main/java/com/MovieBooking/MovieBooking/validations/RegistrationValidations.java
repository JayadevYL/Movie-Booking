package com.MovieBooking.MovieBooking.validations;

import com.MovieBooking.MovieBooking.dao.LoginAndRegistrationRepositoryDao;
import com.MovieBooking.MovieBooking.exceptions.RegistrationException;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegistrationValidations {

    @Autowired LoginAndRegistrationRepositoryDao loginAndRegistrationRepositoryDao;

    public void emailValidation(String email){

        // Validation for the given E-mail
        boolean emailIsValid= EmailValidator.getInstance().isValid(email);
        if (emailIsValid==false){
            // Given Email is not valid so throwing an error
            throw new RegistrationException("The given Email is not valid please provide validate E-mail");
        }
    }

    public void checkingTheGivenEmailWithExistingRegisterMail(String email){
        // Getting all the registered  EmailId List
        List<String> emailList=loginAndRegistrationRepositoryDao.getEmailId();

        // Checking given email is present in the list
        if(emailList.contains(email)){

            // Given Email is already present so throwing an exception
            throw new RegistrationException("The Given Email is already registered, Please login or registered with different Email");
        }
    }

    public void checkingTheGivenPhoneNumberWithExistingRegisterPhoneNumber(String phoneNumber){
        // Getting all the registered phone Number
        List<String> phoneNumberList=loginAndRegistrationRepositoryDao.getPhoneNumber();

        // Checking Given phone number is present in the list
        if (phoneNumberList.contains(phoneNumber)){
            // Given Phone number is already present so throwing an exception
            throw new RegistrationException("The Given Phone Number is already registered, Please register with different Phone Number");
        }
    }
}
