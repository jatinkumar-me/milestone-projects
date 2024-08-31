package com.jatin.flight_search_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jatin.flight_search_service.errors.InvalidSearchRequestException;
import com.jatin.flight_search_service.model.BookingQuotation;
import com.jatin.flight_search_service.service.BookingService;
import com.jatin.flight_search_service.service.SearchRequest;

/**
 * FlightSearchController
 */
@RestController
@RequestMapping("/api")
public class FlightSearchController {

	@Autowired
	BookingService bookingService;

	@PostMapping("/flights")
	public ResponseEntity<?> findFlights(@RequestBody SearchRequest searchRequest) {
		try {
			searchRequest.validateRequest();
			return ResponseEntity.ok(bookingService.findFlightPrices(searchRequest));
		} catch (InvalidSearchRequestException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(500).body("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	@PostMapping("/batch")
    public ResponseEntity<?> insertManyFlights(@RequestBody List<BookingQuotation> flights) {
        try {
            bookingService.saveAll(flights);
            return ResponseEntity.ok("Flights inserted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred while inserting flights: " + e.getMessage());
        }
    }
}
