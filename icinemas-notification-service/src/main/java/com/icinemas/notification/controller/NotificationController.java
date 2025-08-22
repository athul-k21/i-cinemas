package com.icinemas.notification.controller;

import com.icinemas.model.Notification;
import com.icinemas.notification.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/notification")
public class NotificationController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestBody Notification notification) {
        try {
            if (notification.getType() == null) {
                return ResponseEntity.badRequest().body("Notification type is required");
            }

            emailService.sendEmail(notification);
            return ResponseEntity.ok("Notification email sent successfully to " + notification.getEmail());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send email: " + e.getMessage());
        }
    }
}
