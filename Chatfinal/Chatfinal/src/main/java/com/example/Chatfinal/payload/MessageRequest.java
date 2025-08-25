package com.example.Chatfinal.payload;


import lombok.*;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageRequest {

    private String content;
    private String sender;

}
