package com.icinemas.notification.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icinemas.model.Notification;
import com.icinemas.notification.spring.NotificationProperties;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationConsumer.class);

    @Autowired
    private NotificationProperties properties;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmailService emailService;

    @KafkaListener(topics = "#{notificationProperties.topic}", groupId = "#{notificationProperties.consumerGroup}")
    public void consumeNotification(final ConsumerRecord<String, String> record) {
        try {
            final Notification notification = objectMapper.readValue(record.value(),
                    Notification.class);
            if (ObjectUtils.isEmpty(notification) && StringUtils.isBlank(notification.getEmail())) {
                LOGGER.warn("Email is empty in the notification");
                return;
            }
            emailService.sendEmail(notification);

        } catch (JsonProcessingException e) {
            LOGGER.error("Failure in parsing Notification, error = " + e.getMessage());
        }

    }
}
