package com.jatin.hotel_reservation.dto;

import java.time.LocalDate;

import lombok.Data;

/**
 * RoomDTO
 */
@Data
public class RoomDTO {

	private String roomType;
	private boolean isAvailable;
	private LocalDate availableFrom;
	private LocalDate availableTo;
}
