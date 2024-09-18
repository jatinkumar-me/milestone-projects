package com.jatin.hotel_reservation.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jatin.hotel_reservation.dto.RoomDTO;
import com.jatin.hotel_reservation.entity.Room;
import com.jatin.hotel_reservation.service.RoomService;

@RestController
@RequestMapping("/rooms")
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/availability")
    public ResponseEntity<List<Room>> checkRoomAvailability(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate,
            @RequestParam String roomType) {
        return ResponseEntity.ok(roomService.checkRoomAvailability(startDate, endDate, roomType));
    }

    @PostMapping("/batch")
    public ResponseEntity<String> addRooms(@RequestBody List<RoomDTO> roomBatchDTO) {
        try {
            roomService.addRooms(roomBatchDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Rooms added successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error adding rooms: " + e.getMessage());
        }
    }
}
