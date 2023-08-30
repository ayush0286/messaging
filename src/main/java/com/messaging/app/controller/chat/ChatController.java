package com.messaging.app.controller.chat;

import com.messaging.app.dto.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/{to}")
    public void chat(@DestinationVariable String to, ChatMessage chatMessage) {
        System.out.println(to);
        simpMessagingTemplate.convertAndSend("/topic/messages/" + to, chatMessage);
    }

}
