package com.karthikeyan.hms.controller;

import com.karthikeyan.hms.entity.Room;
import com.karthikeyan.hms.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "*")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public Room saveRoom(@RequestBody Room room) {
        room.setCapacity(4);
        room.setCurrentOccupancy(0);
        return roomService.saveRoom(room);
    }

    @GetMapping("/{id}")
    public Optional<Room> getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }

    @GetMapping("/roomNo/{roomNo}")
    public Optional<Room> getRoomByRoomNumber(@PathVariable String roomNo) {
        return roomService.getRoomByRoomNumber(roomNo);
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable Long id, @RequestBody Room room) {
        room.setId(id);
        return roomService.updateRoom(room);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
    }

}
