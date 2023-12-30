package com.example.shareworkchat.domain.chat.service;

import com.example.shareworkchat.common.dto.BasicMeta;
import com.example.shareworkchat.common.dto.Response;
import com.example.shareworkchat.domain.chat.dto.ChatMessageRequest;
import com.example.shareworkchat.domain.chat.dto.ChatRoomRequest;
import com.example.shareworkchat.domain.chat.model.ChatMessage;
import com.example.shareworkchat.domain.chat.model.ChatRoom;
import com.example.shareworkchat.domain.chat.repository.ChatMessageRepository;
import com.example.shareworkchat.domain.chat.repository.ChatRoomRepository;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatService {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;

    public Response createChatRoom(ChatRoomRequest chatRoomRequest) {
        ChatRoom room = new ChatRoom(chatRoomRequest.getUsers(), new Date());
        chatRoomRepository.save(room);
        return new Response(new BasicMeta(true, "채팅방 생성 완료 입니다."));
    }

    public Response sendChatMessage(ChatMessageRequest chatMessageRequest) {
        log.debug("{} - {}: {}", chatMessageRequest.getRoomId(), chatMessageRequest.getSenderId(), chatMessageRequest.getContent());
        ChatMessage message = new ChatMessage(chatMessageRequest.getRoomId(), chatMessageRequest.getSenderId(), chatMessageRequest.getContent(), new Date());
        chatMessageRepository.save(message);
        return new Response(new BasicMeta(true, "메시지 전송 성공 입니다."));
    }

}
