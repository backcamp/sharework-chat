package com.example.shareworkchat.domain.chat.controller.ws;

import com.example.shareworkchat.domain.chat.dto.ChatMessageRequest;
import com.example.shareworkchat.domain.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


@Controller
@RequiredArgsConstructor
public class ChatHandler {

    @Value("${websocket.broker-prefix}")
    private String prefix;

    private final SimpMessagingTemplate template;
    private final ChatService chatService;

    @MessageMapping("/message")
    public void message(ChatMessageRequest request) {
        chatService.sendChatMessage(request);
        template.convertAndSend(prefix + "/chat/room/" + request.getRoomId(), request);
    }

}
