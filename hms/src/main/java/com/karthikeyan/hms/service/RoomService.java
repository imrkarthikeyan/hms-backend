package com.karthikeyan.hms.service;

import com.karthikeyan.hms.entity.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    Room saveRoom(Room room);
    Optional<Room> getRoomById(Long id);
    Optional<Room> getRoomByRoomNumber(String roomNo);
    List<Room> getAllRooms();
    Room updateRoom(Room room);
    void deleteRoom(Long id);
}
