package com.jatin.hotel_reservation.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Room
 */
@Data
@Entity
public class Room {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String roomType;
    
	@Column(nullable = false, columnDefinition = "boolean")	
    private boolean isAvailable;
    private LocalDate availableFrom;
    private LocalDate availableTo;
}
