package com.flight.management.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.management.dto.AddFlightReq;
import com.flight.management.dto.AuthResponse;
import com.flight.management.exception.AuthenticationOrAuthorizationException;
import com.flight.management.exception.FlightAlreadyFoundException;
import com.flight.management.exception.NoFlightsFound;
import com.flight.management.model.FlightDetails;
import com.flight.management.repository.FlightDetailsRepo;
import com.flight.management.service.AdminService;
import com.flight.management.service.AuthorizationService;
import com.flight.management.utils.ConvertAdminDtoToAdminModel;

@Service("adminservice")
public class AdminServiceImpl implements AdminService {

	@Autowired
	FlightDetailsRepo flightDetailsRepo;

	@Autowired
	ConvertAdminDtoToAdminModel dtoToModel;

	@Autowired
	AuthorizationService authService;

	@Override
	public boolean addFlightService(AddFlightReq addFlight, String userName, String password)
			throws FlightAlreadyFoundException, AuthenticationOrAuthorizationException {
		AuthResponse authResponse = authService.authorizationService(userName, password);
		if (authResponse.isAdmin() && authResponse.isAuthorization()) {
			Optional<FlightDetails> flightDetails = flightDetailsRepo.findById(addFlight.getFlightId());
			if (flightDetails.isEmpty()) {
				FlightDetails response = flightDetailsRepo.save(dtoToModel.FlightDetailsDtoToModel(addFlight));
				return (response != null) ? true : false;
			} else {
				throw new FlightAlreadyFoundException("Flight Already Found Exception...!");
			}
		} else {
			throw new AuthenticationOrAuthorizationException("Authentication/Authorization Exception...!");
		}
	}

	@Override
	public List<FlightDetails> getFlightDetails(String userName, String password)
			throws NoFlightsFound, AuthenticationOrAuthorizationException {
		// TODO Auto-generated method stub
		AuthResponse authResponse = authService.authorizationService(userName, password);
		if (authResponse.isAdmin() && authResponse.isAuthorization()) {
			List<FlightDetails> listOfFlightDetails = flightDetailsRepo.findAll();
			if (listOfFlightDetails.size() > 0) {
				return listOfFlightDetails;
			} else {
				throw new NoFlightsFound("No Flights Found...!");
			}
		} else {
			throw new AuthenticationOrAuthorizationException("Authentication/Authorization Exception...!");
		}
	}

	@Override
	public boolean modifyFlightService(AddFlightReq addFlight, String userName, String password) throws NoFlightsFound, AuthenticationOrAuthorizationException {
		AuthResponse authResponse = authService.authorizationService(userName, password);
		if (authResponse.isAdmin() && authResponse.isAuthorization()) {
			Optional<FlightDetails> flightDetails = flightDetailsRepo.findById(addFlight.getFlightId());
			if (!flightDetails.isEmpty()) {
				return (flightDetailsRepo.save(dtoToModel.FlightDetailsDtoToModel(addFlight))!=null);
			} else {
				throw new NoFlightsFound("No Flights Found...!");
			}
		} else {
			throw new AuthenticationOrAuthorizationException("Authentication/Authorization Exception...!");
		}
	}
	
	@Override
	public boolean deleteFlightService(int flightId, String userName, String password) throws NoFlightsFound, AuthenticationOrAuthorizationException {
		AuthResponse authResponse = authService.authorizationService(userName, password);
		if (authResponse.isAdmin() && authResponse.isAuthorization()) {
			Optional<FlightDetails> flightDetails = flightDetailsRepo.findById(flightId);
			if (!flightDetails.isEmpty()) {
				flightDetailsRepo.deleteById(flightId);
				return true;
			} else {
				throw new NoFlightsFound("No Flights Found...!");
			}
		} else {
			throw new AuthenticationOrAuthorizationException("Authentication/Authorization Exception...!");
		}
	}

}
