package com.flight.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.flight.management.dto.AddFlightReq;
import com.flight.management.exception.AuthenticationOrAuthorizationException;
import com.flight.management.exception.FlightAlreadyFoundException;
import com.flight.management.exception.NoFlightsFound;
import com.flight.management.model.FlightDetails;
import com.flight.management.service.AdminService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/addFlight")
	public String addFlight(@RequestBody AddFlightReq addFlight, @RequestHeader String userName,
			@RequestHeader String password) throws FlightAlreadyFoundException, AuthenticationOrAuthorizationException {

		return adminService.addFlightService(addFlight, userName, password) ? "Flight Added...!"
				: "Please try again...!";
	}

	@GetMapping("/viewAllFlights")
	public List<FlightDetails> getFlightDetails(@RequestHeader String userName, @RequestHeader String password)
			throws NoFlightsFound, AuthenticationOrAuthorizationException {
		return adminService.getFlightDetails(userName, password);
	}

	@PostMapping("/modifyFlightDetails")
	public String modifyFlight(@RequestBody AddFlightReq addFlight, @RequestHeader String userName,
			@RequestHeader String password) throws FlightAlreadyFoundException, AuthenticationOrAuthorizationException, NoFlightsFound {

		return adminService.modifyFlightService(addFlight, userName, password) ? "Flight Details Modified...!"
				: "Something went wrong...!";
	}

	@PutMapping("/removeFlight/{id}")
	public String putMethodName(@PathVariable int id, @RequestHeader String userName,
			@RequestHeader String password) throws NoFlightsFound, AuthenticationOrAuthorizationException {

		return adminService.deleteFlightService(id, userName, password) ? "Flight Removed Successfully...!" : "Something went wrong...!";
	}

}
