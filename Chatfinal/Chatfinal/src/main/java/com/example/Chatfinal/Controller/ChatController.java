package com.example.Chatfinal.Controller;


import com.example.Chatfinal.Service.ChatService;
import com.example.Chatfinal.entities.Message;
import com.example.Chatfinal.payload.MessageRequest;
import com.example.Chatfinal.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ChatController {

    private RoomRepository roomRepository;
    private ChatService chatService;

    @Autowired
    public ChatController(RoomRepository roomRepository,ChatService chatService){
         this.roomRepository=roomRepository;
         this.chatService=chatService;
    }

    //send message

    @MessageMapping("/sendMessage/{roomId}") //this is endpoint users/client hit on BE;they hit /app/sendMessage/roomid
    @SendTo("/topic/room/{roomId}")//this is where whatever is returned from this method goes: goes to the inmemory message broker that broadcasts the message to the url;
    public Message sendMessage(@Payload MessageRequest messageRequest, @DestinationVariable String roomId){
        return chatService.sendMessage(messageRequest,roomId);
    }








}
