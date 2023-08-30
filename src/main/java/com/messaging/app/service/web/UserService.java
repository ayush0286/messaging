package com.messaging.app.service.web;

import com.messaging.app.dto.UserChatChannel;
import com.messaging.app.dto.UserDto;
import com.messaging.app.enums.ChannelType;
import com.messaging.app.model.Group;
import com.messaging.app.model.PrivateMessage;
import com.messaging.app.model.User;
import com.messaging.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserChatService userChatService;

    @Autowired
    PrivateMessageService privateMessageService;

    public void registerUser(String userName, String phoneNumber) throws Exception {
        checkIfUserExists(userName.toLowerCase().trim(), phoneNumber.trim());
        User user = new User(userName, phoneNumber);
        userRepository.save(user);
    }

    public UserDto loginUser(String userName, String phoneNumber) throws Exception {
        User user = userRepository.findByUserNameAndPhoneNumber(userName, phoneNumber);
        if (ObjectUtils.isEmpty(user)) {
            throw new Exception("User doesn't exist:" + userName + " and phone number: " + phoneNumber+". Please register");
        }
        UserDto userDto = new UserDto();
        userDto.setUserName(user.getUserName());
        userDto.setPhoneNumber(userDto.getPhoneNumber());
        userDto.setId(user.getId());
        return userDto;
    }

    public List<UserDto> searchUserForChat(String searchInput) throws Exception {
        List<User> userList = userRepository.getAllUserForMatchingInputFromUserNameOrPhoneNumber(searchInput.toLowerCase().trim());
        if (CollectionUtils.isEmpty(userList)) {
            throw new Exception("User not found with input: " + searchInput);
        }
        List<UserDto> userDtos = new ArrayList<>();
        for(User user:userList){
            UserDto userDto = new UserDto();
            userDto.setUserName(user.getUserName());
            userDto.setPhoneNumber(userDto.getPhoneNumber());
            userDto.setId(user.getId());
            userDtos.add(userDto);
        }

        return userDtos;
    }

    public List<UserChatChannel> getAllChatForUser(String userName, String phoneNumber) throws Exception {
        User user = checkIfUserExists(userName, phoneNumber);
        Set<Long> userIds = userChatService.getAllUserChat(user.getId());

        List<User> userList = userRepository.findAllById(userIds);
        List<UserChatChannel> userChatChannels = new ArrayList<>();
        for (User user1 : userList) {
            UserChatChannel userChatChannel = new UserChatChannel();
            userChatChannel.setChannelName(ChannelType.ONE_TO_ONE.name());
            userChatChannel.setChannelName(user1.getUserName());
            userChatChannels.add(userChatChannel);
        }

     /*   Set<Long> groupUserIds = userGroupRepository.getAllUserGroups(user.getId());
        List<Group> groups = groupRepository.findAllById(groupUserIds);

        for (Group group : groups) {
            UserChatChannel userChatChannel = new UserChatChannel();
            userChatChannel.setChannelName(ChannelType.GROUP.name());
            userChatChannel.setChannelName(group.getGroupName());
            userChatChannels.add(userChatChannel);
        }*/
        return userChatChannels;
    }

    public void getOneToOneUserChat(String firstUserName, String secondUserName) throws Exception {
        User userOne = checkIfUserExists(firstUserName,"");
        User userTwo = checkIfUserExists(secondUserName,"");
        String userToUserChatId = userChatService.getUserToUserChatId(userOne.getId(),userTwo.getId());
        List<PrivateMessage> privateMessages = privateMessageService.getPrivateMessages(userToUserChatId, 10);

    }

    private User checkIfUserExists(String userName, String phoneNumber) throws Exception {
        User user = userRepository.findByUserNameAndPhoneNumber(userName, phoneNumber);
        if (!ObjectUtils.isEmpty(user)) {
            throw new Exception("User already exists with user-name:" + userName + " and phone number: " + phoneNumber);
        }
        return user;
    }



}