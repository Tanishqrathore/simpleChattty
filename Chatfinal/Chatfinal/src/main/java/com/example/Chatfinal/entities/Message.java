package com.example.Chatfinal.entities;


import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Message {
    private String sender;
    private String content;
    private LocalDateTime timestamp;

    public Message(String sender,String content){
        this.sender=sender;
        this.content=content;
        this.timestamp=LocalDateTime.now();
    }
}

//gotta study this LocalDateTime in java: asked in mastercard iw;
