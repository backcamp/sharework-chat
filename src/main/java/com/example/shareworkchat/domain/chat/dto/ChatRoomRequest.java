package com.example.shareworkchat.domain.chat.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatRoomRequest {

    private List<String> users;

}
