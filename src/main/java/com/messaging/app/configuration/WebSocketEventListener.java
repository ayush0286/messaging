//package com.messaging.app.configuration;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import com.messaging.app.dto.ChatMessage;
////import com.messaging.app.enums.MessageType;
//import org.springframework.context.event.EventListener;
//import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
//import org.springframework.messaging.simp.SimpMessageSendingOperations;
//import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
//import org.springframework.stereotype.Component;
//import org.springframework.util.ObjectUtils;
//import org.springframework.web.socket.messaging.SessionConnectedEvent;
//import org.springframework.web.socket.messaging.SessionDisconnectEvent;
//
//@Component
//@Slf4j
//@RequiredArgsConstructor
//public class WebSocketEventListener {
//
//    private final SimpMessageSendingOperations messageSendingOperations;
//
//    @EventListener
//    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
//        SimpMessageHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
//        String username = (String) headerAccessor.getSessionAttributes().get("username");
//        if (!ObjectUtils.isEmpty(username)) {
//            log.info("User disconnected:: {}", username);
//            ChatMessage message = ChatMessage.builder()
////                    .type(MessageType.LEAVE)
//                    .sender(username)
//                    .build();
////            messageSendingOperations.convertAndSend("/topic/public", message);
//        }
//    }
//
//    @EventListener
//    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
//        SimpMessageHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
//        String username = (String) headerAccessor.getSessionAttributes().get("username");
//        if (!ObjectUtils.isEmpty(username)) {
//            log.info("User connected:: {}", username);
////            ChatMessage message = ChatMessage.builder()
////                    .type(MessageType.JOIN)
////                    .sender(username)
////                    .build();
////            messageSendingOperations.convertAndSend("/topic/public", message);
//        }
//    }
//}
