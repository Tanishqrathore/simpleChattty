package com.example.Chatfinal.Service;

import com.example.Chatfinal.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "chat-messages";

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    public void sendMessage(Message message) {
        // KafkaTemplate automatically converts the ChatMessage object to JSON
        kafkaTemplate.send(TOPIC, message);
    }
}
