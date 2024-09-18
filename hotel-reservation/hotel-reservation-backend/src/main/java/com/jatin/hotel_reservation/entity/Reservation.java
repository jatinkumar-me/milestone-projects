package com.jatin.hotel_reservation.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long userId;
    private String roomType;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
