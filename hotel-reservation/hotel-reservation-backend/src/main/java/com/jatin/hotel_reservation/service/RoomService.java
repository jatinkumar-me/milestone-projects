package com.jatin.hotel_reservation.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jatin.hotel_reservation.dto.RoomDTO;
import com.jatin.hotel_reservation.entity.Room;
import com.jatin.hotel_reservation.repository.RoomRepository;

import jakarta.transaction.Transactional;

@Service
public class RoomService {
    
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> checkRoomAvailability(LocalDate startDate, LocalDate endDate, String roomType) {
        return roomRepository.findAvailableRooms(startDate, endDate, roomType);
    }

    @Transactional
    public void addRooms(List<RoomDTO> rooms) {
        List<Room> roomEntities = rooms.stream().map(dto -> {
            Room room = new Room();
            room.setRoomType(dto.getRoomType());
            room.setAvailable(dto.isAvailable());
            room.setAvailableFrom(dto.getAvailableFrom());
            room.setAvailableTo(dto.getAvailableTo());
            return room;
        }).toList();
        roomRepository.saveAll(roomEntities);
    }
}
