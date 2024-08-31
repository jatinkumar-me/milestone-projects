package com.jatin.flight_search_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.jatin.flight_search_service.model.BookingQuotation;
import com.jatin.flight_search_service.repository.BookingRepository;

/**
 * BookingService
 */
@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepository;

	@Cacheable(cacheNames = "flightPrices", key = "#searchRequest")
	public List<BookingQuotation> findFlightPrices(SearchRequest searchRequest) {
		System.out.println("Coming from mongodb"); //This will print if the searchRequest doesn't hit the cache.
		if (searchRequest.getReturnDate() == null || searchRequest.getDepartureDate() == null) {
			return bookingRepository
					.findBookingsBySourceAndDestination(
							searchRequest.getSource(),
							searchRequest.getDestination());
		}
		return bookingRepository
				.findBookBySourceDestinationDepartureAndReturnDate(
						searchRequest.getSource(),
						searchRequest.getDestination(),
						searchRequest.getDepartureDate(),
						searchRequest.getReturnDate());
	}

	@CacheEvict(cacheNames = "flightPrices")
	public void saveAll(List<BookingQuotation> flights) {
		bookingRepository.saveAll(flights);
		for (BookingQuotation bookingQuotation : flights) {
			bookingQuotation.hashCode();
		}
	}

}
