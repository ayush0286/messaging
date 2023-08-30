package com.messaging.app.service.web;

import com.messaging.app.model.User;
import com.messaging.app.model.UserChat;
import com.messaging.app.repository.UserChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class UserChatService {

    @Autowired
    UserChatRepository userChatRepository;

    public Set<Long> getAllUserChat(long userId) {
        List<UserChat> userChats = userChatRepository.findAllUserChat(userId);
        Set<Long> userIds = userChats.stream().map(userChat -> {
            if (userChat.getFirstUser() != userId)
                return userChat.getFirstUser();
            {
                return userChat.getSecondUser();
            }
        }).collect(Collectors.toSet());
        return userIds;
    }

    public String getUserToUserChatId(long userOneId, long userTwoId) {
        String userToUserChatId  = null;
//                = userChatRepository.findUserToUserChatId(userOneId,userTwoId);
        return userToUserChatId;
    }
}
