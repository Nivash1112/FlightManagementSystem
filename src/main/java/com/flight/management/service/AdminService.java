package com.flight.management.service;

import org.springframework.stereotype.Service;

import com.flight.management.dto.AddFlightReq;
import com.flight.management.exception.AuthenticationOrAuthorizationException;
import com.flight.management.exception.FlightAlreadyFoundException;

@Service
public interface AdminService {

	public boolean addFlightService(AddFlightReq addFlight, String userName, String password) throws FlightAlreadyFoundException, AuthenticationOrAuthorizationException;
}
