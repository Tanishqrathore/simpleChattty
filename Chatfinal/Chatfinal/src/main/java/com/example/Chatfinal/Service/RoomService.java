package com.example.Chatfinal.Service;


import com.example.Chatfinal.entities.Message;
import com.example.Chatfinal.entities.Room;
import com.example.Chatfinal.repositories.RoomRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Data
@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;


    public Room createNewRoom(String roomId) {
      if(roomRepository.findByRoomId(roomId)!=null){return null;}
       Room room = new Room();
       room.setRoomId(roomId);

       return roomRepository.save(room); //this also returns the saved entity,along with saving it;
    }

    public Room getRoom(String roomId) {
         return roomRepository.findByRoomId(roomId);
    }

    public List<Message> getMessage(String roomId) {
        Room room = roomRepository.findByRoomId(roomId);
        if(room==null){return null;}
        return room.getMessages();
    }
}
