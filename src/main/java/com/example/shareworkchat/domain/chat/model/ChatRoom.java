package com.example.shareworkchat.domain.chat.model;

import java.util.Date;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "chat_room")
public class ChatRoom {

    @Id
    private ObjectId id;

    private List<String> users;
    private Date createdAt;

    @Builder
    public ChatRoom(List<String> users, Date date) {
        this.users = users;
        this.createdAt = date;
    }
}
