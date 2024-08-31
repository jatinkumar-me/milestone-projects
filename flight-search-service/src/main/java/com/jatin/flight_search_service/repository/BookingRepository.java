package com.jatin.flight_search_service.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.jatin.flight_search_service.model.BookingQuotation;

/**
 * FlightRepository
 */
public interface BookingRepository extends MongoRepository<BookingQuotation, String> {

	// List<BookingQuotation>
	// findByOriginAndDestinationAndDepartureDateAndReturnDate(
	// String origin,
	// String destination,
	// LocalDate departureDate,
	// LocalDate returnDate);

	// List<BookingQuotation> findByOriginAndDestination(
	// String origin,
	// String destination);

	@Query("{'source': ?0, 'destination': ?1 }")
	List<BookingQuotation> findBookingsBySourceAndDestination(
			String source,
			String destination);

	@Query("{'source': ?0, 'destination': ?1, 'departureDate': ?2, 'returnDate': ?3}")
	List<BookingQuotation> findBookBySourceDestinationDepartureAndReturnDate(
			String source,
			String destination,
			LocalDateTime departureDate,
			LocalDateTime returnDate);

}
