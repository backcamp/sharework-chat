package com.example.shareworkchat.domain.chat.controller;

import com.example.shareworkchat.common.dto.Response;
import com.example.shareworkchat.domain.chat.dto.ChatMessageRequest;
import com.example.shareworkchat.domain.chat.dto.ChatRoomRequest;
import com.example.shareworkchat.domain.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping("/create")
    public ResponseEntity<Response> createChatRoom(@RequestBody ChatRoomRequest chatRoomRequest) {
        Response response = chatService.createChatRoom(chatRoomRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/send")
    public ResponseEntity<Response> sendChatMessage(@RequestBody ChatMessageRequest chatMessageRequest) {
        Response response = chatService.sendChatMessage(chatMessageRequest);
        return ResponseEntity.ok(response);
    }

}
