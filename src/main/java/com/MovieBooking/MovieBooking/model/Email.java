package com.MovieBooking.MovieBooking.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class Email {

    @Autowired private JavaMailSender javaMailSender;
    public void sendMailForRegistration(String to, String username){
        String subject="Registration success";
        String body= username + "Thank you for choosing JD app to book movie ticket";
        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        message.setFrom("jayadev@jsw.in");

        javaMailSender.send(message);
    }
}
