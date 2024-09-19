package com.jatin.hotel_reservation.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jatin.hotel_reservation.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
	@Query(value = "SELECT * FROM room r WHERE r.is_available = 1 AND r.room_type = :roomType AND r.available_from <= :startDate AND r.available_to >= :endDate", nativeQuery = true)
	List<Room> findAvailableRooms(LocalDate startDate, LocalDate endDate, String roomType);
}
