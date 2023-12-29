package com.example.shareworkchat.domain.chat.repository;

import com.example.shareworkchat.domain.chat.model.ChatRoom;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {

}
