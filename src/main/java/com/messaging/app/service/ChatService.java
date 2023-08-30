//package com.messaging.app.service;
//
//import com.messaging.app.dto.ChatMessage;
//import com.messaging.app.dto.UserChatChannel;
//import com.messaging.app.enums.ChannelType;
//import com.messaging.app.enums.MessageType;
//import com.messaging.app.model.*;
//import com.messaging.app.repository.*;
//import com.messaging.app.service.web.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.ObjectUtils;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//@Service
//public class ChatService {
//
//    @Autowired
//    UserGroupRepository userGroupRepository;
//
//    @Autowired
//    GroupRepository groupRepository;
//
//    @Autowired
//    UserChatRepository userChatRepository;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    MessagingRepository messagingRepository;
//
//    @Autowired
//    UserService userService;
//
//    public Set<String> getAllChannels(String userName) {
//        Set<UserChatChannel> userChatChannels = new HashSet<>();
////        userChatChannels.addAll(getGroupChannelForUser(userName));
//        userChatChannels.addAll(getChatChannelForUser(userName));
//        Set<String> channels = userChatChannels.stream().map(e -> e.getChannelName()).collect(Collectors.toSet());
//        return channels;
//    }
//
//    private Set<UserChatChannel> getChatChannelForUser(String userName) {
//        Set<UserChatChannel> userChatChannels = new HashSet<>();
//        User user = userRepository.findByUserName(userName);
//        List<UserMessage> userChats = userChatRepository.findByFromUserId(user.getId());
//        List<Long> toUserIds = userChats.stream().map(userChat -> userChat.getToUserId()).collect(Collectors.toList());
//        List<User> users = userRepository.findAllById(toUserIds);
//        for (User u : users) {
//            UserChatChannel userChatChannel = new UserChatChannel();
//            userChatChannel.setChannelType(ChannelType.ONE_TO_ONE);
//            userChatChannel.setChannelName(u.getUserName());
//        }
//        return userChatChannels;
//    }
//
//    private Set<UserChatChannel> getGroupChannelForUser(String userId) {
//        Set<UserChatChannel> userChatChannels = new HashSet<>();
//        List<UserGroup> userGroups = userGroupRepository.findByUserId(userId);
//        List<Long> groupIds = userGroups.stream().map(userGroup -> userGroup.getGroupId()).collect(Collectors.toList());
//        List<Group> groups = groupRepository.findAllById(groupIds);
//
//        for (Group group : groups) {
//            UserChatChannel userChatChannel = new UserChatChannel();
//            userChatChannel.setChannelType(ChannelType.GROUP);
//            userChatChannel.setChannelName(group.getGroupName());
//        }
//        return userChatChannels;
//    }
//
//    public void getMessages(String userId, String channelId, String channelType) {
//
//
//    }
//
//    public void addMessage(String senderId, String receiverId, Object Message) {
//
//    }
//
//
//    public void saveUserConversation(String to, ChatMessage message) throws Exception {
//        User userFrom = userRepository.findByUserName(message.getFromLogin());
//        User userTo = userRepository.findByUserName(to);
//        if(ObjectUtils.isEmpty(to)){
//            userService.addUser(userTo.getUserName());
//        }
//        if (!ObjectUtils.isEmpty(userFrom)) {
//            Message msg = new Message();
//            msg.setMessageType(MessageType.CHAT.name());
//            msg.setUserId(userTo.getId());
//            msg.setContent(msg.getContent());
//            msg = messagingRepository.save(msg);
//
//            UserMessage userMessage = new UserMessage();
//            userMessage.setMessageId(msg.getId());
//            userMessage.setFromUserId(userFrom.getId());
//            userMessage.setToUserId(userTo.getId());
//            userChatRepository.save(userMessage);
//        }
//    }
//}
