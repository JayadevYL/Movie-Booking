package com.MovieBooking.MovieBooking.controller;

import com.MovieBooking.MovieBooking.model.LoginCredential;
import com.MovieBooking.MovieBooking.model.ResponseObject;
import com.MovieBooking.MovieBooking.model.UserDetails;
import com.MovieBooking.MovieBooking.service.LoginAndRegistrationService;
import com.MovieBooking.MovieBooking.service.UpdateCustomerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class LoginAndRegistrationController {

    @Autowired private LoginAndRegistrationService loginAndRegistrationService;
    @Autowired private ResponseObject responseObject;
    @Autowired private UpdateCustomerImpl updateCustomer;

    @PostMapping("/registration/submit")
    public ResponseEntity<UserDetails> registrationSubmit(@RequestBody UserDetails userDetails){
//        return new ResponseEntity<>(loginAndRegistrationService.save(userDetails), HttpStatus.CREATED)
        UserDetails savedDetails=loginAndRegistrationService.save(userDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDetails);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseObject> login(@RequestBody LoginCredential loginCredential){
        String response = loginAndRegistrationService.loginVerify(loginCredential);
        responseObject.setStatus("200");
        responseObject.setMessage(response);
        return ResponseEntity.ok(responseObject);
    }
    // Update the password using Email
    @PostMapping("/password")
    public ResponseEntity<String> updateTheCustomerPassword(@RequestBody UserDetails passwordReceivedFromCustomer){
         updateCustomer.updatePassword(passwordReceivedFromCustomer);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully password is updated");
    }

    //Delete customer using Email
    @PostMapping("/delete")
    public ResponseEntity<String> deleteTheCustomer(@RequestBody UserDetails deleteCustomer){
        updateCustomer.deleteTheCustomer(deleteCustomer);
        return ResponseEntity.status(HttpStatus.OK).body("Account is successfully deleted");
    }
}
