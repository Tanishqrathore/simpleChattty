package com.example.writer_service.Service;

import com.example.writer_service.entity.ChatMessage;
import com.example.writer_service.entity.Message;
import com.example.writer_service.entity.Room;
import com.example.writer_service.repository.MongoDBrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Kafka_consumer {

    @Autowired
    private MongoDBrepo mongoDBrepo;

    @KafkaListener(topics = "chat-messages", groupId = "chat-db-writer-group")
    public void consume(Message message) {
        String roomId= message.getRoomId();
        Room room = mongoDBrepo.findByRoomId(roomId);
        if(room!=null){
            ChatMessage chatMessage = new ChatMessage(message.getSender(),message.getContent());
            room.getMessages().add(chatMessage);
            mongoDBrepo.save(room);
        }
    }
}
