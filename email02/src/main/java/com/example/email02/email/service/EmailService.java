package com.example.email02.email.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendTo(String email, String title, String text) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg = "<h1>Benvenuto!</h1>" +
                "<h2>Hai ricevuto un nuovo messaggio!!!</h2>" +
                "<img src=https://media-assets.wired.it/photos/62a6ede3caa182924b403d43/3:2/w_854,h_570,c_limit/spider-man-no-way-home.jpg>" +
                "<h3>" + text + "</h3>";
        helper.setText(htmlMsg, true);
        helper.setTo(email);
        helper.setSubject(title);
        helper.setFrom("emailesercizidev@gmail.com");
        javaMailSender.send(mimeMessage);
    }
}
