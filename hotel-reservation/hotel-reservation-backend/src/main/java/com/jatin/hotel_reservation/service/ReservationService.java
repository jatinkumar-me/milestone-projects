package com.jatin.hotel_reservation.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jatin.hotel_reservation.entity.Reservation;
import com.jatin.hotel_reservation.entity.ReservationStatus;
import com.jatin.hotel_reservation.entity.Room;
import com.jatin.hotel_reservation.repository.ReservationRepository;
import com.jatin.hotel_reservation.repository.RoomRepository;

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;

	@Autowired
	private RoomRepository roomRepository;

    public Reservation createReservation(Reservation reservation) {
        reservation.setStatus(ReservationStatus.PENDING);
        reservation.setCreatedAt(LocalDateTime.now());
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getUserReservations(Long userId) {
        return reservationRepository.findByUserId(userId);
    }

    public Reservation updateReservation(Long id, Reservation updatedReservation) {
        Reservation existingReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        if (!existingReservation.getRoomType().equals(updatedReservation.getRoomType()) || 
            !existingReservation.getCheckInDate().equals(updatedReservation.getCheckInDate()) || 
            !existingReservation.getCheckOutDate().equals(updatedReservation.getCheckOutDate())) {

            List<Room> availableRooms = roomRepository.findAvailableRooms(
                updatedReservation.getCheckInDate(), 
                updatedReservation.getCheckOutDate(), 
                updatedReservation.getRoomType());

            if (availableRooms.isEmpty()) {
                throw new RuntimeException("Room not available for the selected dates");
            }
        }

        existingReservation.setRoomType(updatedReservation.getRoomType());
        existingReservation.setCheckInDate(updatedReservation.getCheckInDate());
        existingReservation.setCheckOutDate(updatedReservation.getCheckOutDate());
        existingReservation.setUpdatedAt(LocalDateTime.now());

        return reservationRepository.save(existingReservation);
    }

    public void cancelReservation(Long id) {
        Reservation existingReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        existingReservation.setStatus(ReservationStatus.CANCELLED);
        existingReservation.setUpdatedAt(LocalDateTime.now());

		Room room = roomRepository.findById(existingReservation.getId()).orElseThrow();
        room.setAvailable(true);

        reservationRepository.save(existingReservation);
        roomRepository.save(room);
    }

    public Reservation getReservation(Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation not found"));
    }
}
