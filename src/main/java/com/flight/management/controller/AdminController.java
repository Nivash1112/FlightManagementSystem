package com.flight.management.controller;

import org.springframework.web.bind.annotation.RestController;

import com.flight.management.dto.AddFlightReq;
import com.flight.management.exception.AuthenticationOrAuthorizationException;
import com.flight.management.exception.FlightAlreadyFoundException;
import com.flight.management.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/addFlight")
	public String addFlight(@RequestBody AddFlightReq addFlight, @RequestHeader String userName,
			@RequestHeader String password) throws FlightAlreadyFoundException, AuthenticationOrAuthorizationException {

		
		return adminService.addFlightService(addFlight, userName, password) ? "Flight Added...!" : "Please try again...!";
	}

}
