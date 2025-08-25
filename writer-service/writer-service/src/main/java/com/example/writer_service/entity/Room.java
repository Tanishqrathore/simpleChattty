package com.example.writer_service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Document(collection = "rooms")
@Data
public class Room {
    @Id
    private String id; //mongodb uid
    private String roomId;

    private List<ChatMessage> messages = new ArrayList<>();
}