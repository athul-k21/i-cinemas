package com.icinemas.notification.spring;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("notification")
@Component
@Getter
@Setter
public class NotificationProperties {
    private String topic;
    private String consumerGroup;
}
