package com.example.shareworkchat.domain.chat.model;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "chat_message")
public class ChatMessage {

    @Id
    private ObjectId id;

    private String roomId;
    private String senderId;
    private String content;
    private Date timestamp;

    @Builder
    public ChatMessage(String roomId, String senderId, String content, Date ts) {
        this.roomId = roomId;
        this.senderId = senderId;
        this.content = content;
        this.timestamp = ts;
    }
}
