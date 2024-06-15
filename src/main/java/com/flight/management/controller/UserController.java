package com.flight.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.management.dto.UserSignUp;
import com.flight.management.exception.UserAlreadyFoundException;
import com.flight.management.service.UserService;



@RestController
public class UserController {
	
	@Autowired
	private UserService userSerivce;
	

	@PostMapping("/signUp")
	public String postMethodName(@RequestBody UserSignUp entity) throws UserAlreadyFoundException {
		userSerivce.createUser(entity);
		return "user Created. Have a great day...!";
	}
	
	
}
