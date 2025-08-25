package com.example.Chatfinal.Controller;


import com.example.Chatfinal.Service.RoomService;
import com.example.Chatfinal.entities.Message;
import com.example.Chatfinal.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
@CrossOrigin("*")
public class RoomController {


    RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService){
        this.roomService=roomService;
    }

    //create room
    @PostMapping("/create")
    public ResponseEntity<?> createRoom(@RequestBody String roomId){
          Room room=roomService.createNewRoom(roomId);
          if(room==null){return ResponseEntity.badRequest().body("Room already exists");}
          return ResponseEntity.ok(room);
    }

    //get room:to join room
    @GetMapping("/get/{roomId}")
    public ResponseEntity<?> getRoom(@PathVariable String roomId){
         Room room=roomService.getRoom(roomId);
         if(room==null){return ResponseEntity.badRequest().body("Room does not exist");}
         return ResponseEntity.ok(room);
    }


    //get messages of room
    //scope of pagination is here(for reverse infinite scrolling)
    @GetMapping("/{roomId}/messages")
    public ResponseEntity<?> getMessage(@PathVariable String roomId){
        List<Message> txt = roomService.getMessage(roomId);
        if(txt==null){return ResponseEntity.badRequest().body("Room does not exist");}
        return ResponseEntity.ok(txt);
    }


}

//i initially thought of handling room not existing errors in my frontend, but imo:backend api's should be self sufficient
//i.e. a frontend engineer shudn't really know internals of backendapi to work with it so common pitfalls shud be returned as a bad request
