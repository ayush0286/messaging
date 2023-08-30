package com.messaging.app.dto;

//import com.messaging.app.enums.MessageType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessage {
    private String content;
    private String sender;
//    private MessageType type;

    private String phoneNumber;

    private long userId;

    private String fromLogin;
    private String message;
}
