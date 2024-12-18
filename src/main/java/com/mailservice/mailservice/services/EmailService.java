package com.mailservice.mailservice.services;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.util.Date;

@EnableScheduling
@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendReport(String content, String to){
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            int currentMonth = new Date().getMonth();

            helper.setFrom("arthur1999@gmail.com");
            helper.setText(content, true);
            helper.setSubject("Monthly Report - " + currentMonth);
            helper.setTo(to);
            javaMailSender.send(message);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
