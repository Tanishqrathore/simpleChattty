package com.example.Chatfinal.repositories;


import com.example.Chatfinal.entities.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room,String> {
    //get room using room id
    Room findByRoomId(String roomId);
}

//Spring Data MongoDB repository interface
//<Room,String>
//Room: the class that is entity; String: data type of id;