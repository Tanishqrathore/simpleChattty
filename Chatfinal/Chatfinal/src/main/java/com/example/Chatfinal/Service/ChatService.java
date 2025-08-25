package com.example.Chatfinal.Service;


import com.example.Chatfinal.entities.Message;
import com.example.Chatfinal.entities.Room;
import com.example.Chatfinal.payload.MessageRequest;
import com.example.Chatfinal.repositories.RoomRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Getter
@Setter
@NoArgsConstructor
public class ChatService {
    RoomRepository roomRepository;

    @Autowired
    public ChatService(RoomRepository roomRepository){this.roomRepository=roomRepository;
    }

    public Message sendMessage(MessageRequest messageRequest,String roomId){
         Room room=roomRepository.findByRoomId(roomId); if(room==null){return null;}
         Message message = new Message();
         message.setContent(messageRequest.getContent());
         message.setTimestamp(LocalDateTime.now());
         message.setSender(messageRequest.getSender());

         //save in DB;
         room.getMessages().add(message);
         roomRepository.save(room);

         return message;
    }

}
