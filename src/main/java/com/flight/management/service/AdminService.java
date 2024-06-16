package com.flight.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flight.management.dto.AddFlightReq;
import com.flight.management.exception.AuthenticationOrAuthorizationException;
import com.flight.management.exception.FlightAlreadyFoundException;
import com.flight.management.exception.NoFlightsFound;
import com.flight.management.model.FlightDetails;

@Service
public interface AdminService {

	public boolean addFlightService(AddFlightReq addFlight, String userName, String password) throws FlightAlreadyFoundException, AuthenticationOrAuthorizationException;

	public List<FlightDetails> getFlightDetails(String userName, String password) throws NoFlightsFound, AuthenticationOrAuthorizationException;

	public boolean modifyFlightService(AddFlightReq addFlight, String userName, String password) throws NoFlightsFound, AuthenticationOrAuthorizationException;

	boolean deleteFlightService(int flightId, String userName, String password)
			throws NoFlightsFound, AuthenticationOrAuthorizationException;
}
