package com.icinemas.model;

import com.icinemas.enums.NotificationType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
public class Notification {
    private String id;
    private NotificationType type;
    private String transactionId;
    private String remarks;
    private String userId;
    private String email;
}
