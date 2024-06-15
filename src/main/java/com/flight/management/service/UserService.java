package com.flight.management.service;

import org.springframework.stereotype.Service;

import com.flight.management.dto.UserSignUp;
import com.flight.management.exception.UserAlreadyFoundException;

@Service
public interface UserService {

	public boolean createUser(UserSignUp userDetails) throws UserAlreadyFoundException;

	public Object findByUsername(String username);
}
