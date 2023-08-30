package com.messaging.app.dto;

import com.messaging.app.enums.ChannelType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
//@RequiredArgsConstructor
public class UserChatChannel {
    private ChannelType channelType;
    private String channelName;
    private String channelLastMessage;


}
