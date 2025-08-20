package com.icinemas.notification.service;

import com.icinemas.model.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(final Notification notification) {
        try {
            final SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(notification.getEmail());
            mailMessage.setSubject(notification.getType().getSubject());
            mailMessage.setText(notification.getType().getDefaultMessage());

            mailSender.send(mailMessage);
        }
        catch (Exception e) {

            LOGGER.error("Failure in sending email notification, error =" + e.getMessage());
        }
    }
}
