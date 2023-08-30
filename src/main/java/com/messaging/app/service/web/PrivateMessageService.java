package com.messaging.app.service.web;

import com.messaging.app.model.PrivateMessage;
import com.messaging.app.repository.PrivateMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrivateMessageService {

    @Autowired
    PrivateMessageRepository privateMessageRepository;

    public List<PrivateMessage> getPrivateMessages(String userToUserChatId, int messageCountLimit) {
        return null;
    }
}
