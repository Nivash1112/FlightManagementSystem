package com.flight.management.controller;

import org.springframework.web.bind.annotation.RestController;

import com.flight.management.dto.AddFlightReq;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AdminController {

	@PostMapping("/addFlight")
	public String addFlight(@RequestBody AddFlightReq addFlight) {
		return "";
	}
	
	
}
