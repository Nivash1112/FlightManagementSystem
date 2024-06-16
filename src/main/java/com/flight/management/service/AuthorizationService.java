package com.flight.management.service;

import org.springframework.stereotype.Service;

import com.flight.management.dto.AuthResponse;

@Service
public interface AuthorizationService {

	public AuthResponse authorizationService(String userName, String password);
}
