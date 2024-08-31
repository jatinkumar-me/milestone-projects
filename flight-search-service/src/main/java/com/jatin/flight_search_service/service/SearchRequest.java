package com.jatin.flight_search_service.service;

import java.time.LocalDateTime;

import com.jatin.flight_search_service.errors.InvalidSearchRequestException;

public class SearchRequest {

	private String source;
	private String destination;
	private LocalDateTime departureDate;
	private LocalDateTime returnDate;

	public SearchRequest() {
	}

	public SearchRequest(String origin, String destination, LocalDateTime departureDate, LocalDateTime returnDate) {
		this.source = origin;
		this.destination = destination;
		this.departureDate = departureDate;
		this.returnDate = returnDate;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String origin) {
		this.source = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDateTime getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}

	public void validateRequest() throws InvalidSearchRequestException {
		if (this.departureDate != null && this.returnDate != null) {
			if (this.departureDate.isAfter(this.returnDate)) {
				throw new InvalidSearchRequestException("Departure date should be before return date");
			}
		}

		if (this.source.equals(this.destination)) {
			throw new InvalidSearchRequestException("Origin and destination cannot be the same.");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((departureDate == null) ? 0 : departureDate.hashCode());
		result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SearchRequest other = (SearchRequest) obj;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (departureDate == null) {
			if (other.departureDate != null)
				return false;
		} else if (!departureDate.equals(other.departureDate))
			return false;
		if (returnDate == null) {
			if (other.returnDate != null)
				return false;
		} else if (!returnDate.equals(other.returnDate))
			return false;
		return true;
	}
}
