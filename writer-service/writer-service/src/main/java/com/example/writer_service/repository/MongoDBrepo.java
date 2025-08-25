package com.example.writer_service.repository;

import com.example.writer_service.entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoDBrepo extends MongoRepository<Room,String> {
    //get room using room id
    Room findByRoomId(String roomId);
}