package com.flight.management.utils;

import org.springframework.stereotype.Service;

import com.flight.management.dto.AddFlightReq;
import com.flight.management.model.FlightDetails;

@Service
public class ConvertAdminDtoToAdminModel {

	public FlightDetails FlightDetailsDtoToModel(AddFlightReq addFlight) {
		FlightDetails flightDetails = new FlightDetails(addFlight.getFlightId(), addFlight.getFlightName(),
				addFlight.getVendor(), addFlight.getPrice(), addFlight.getFromPlace(), addFlight.getToDestination(),
				addFlight.getJourneyDate());
		return flightDetails;
	}
}
