package com.example.shareworkchat.domain.chat.repository;

import com.example.shareworkchat.domain.chat.model.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {

}
