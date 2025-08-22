package com.icinemas.notification.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;

@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = { "icinemas-notifications" })
public class NotificationConsumerTest {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    void testConsumeBookingEvent() throws Exception {
        String message = "{\"transactionId\":\"TXN123\",\"userId\":\"U1\",\"email\":\"test@example.com\",\"status\":\"CONFIRMED\",\"description\":\"Movie XYZ\",\"timestamp\":\"2025-08-20T15:30:00Z\"}";

        kafkaTemplate.send("icinemas-notifications\"", message);

        // Wait a few seconds and check logs or mock EmailService
        Thread.sleep(2000);
    }
}
