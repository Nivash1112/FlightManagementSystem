package com.flight.management.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.management.dto.AuthResponse;
import com.flight.management.model.UserModel;
import com.flight.management.repository.UserRepository;
import com.flight.management.service.AuthorizationService;

@Service("authorizationservice")
public class AuthorizationServiceImpl implements AuthorizationService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public AuthResponse authorizationService(String userName, String password) {
		Optional<UserModel> user= userRepo.findById(userName);
		AuthResponse authReponse=new AuthResponse(false, false);
		if(user.get().getPassword().equals(password)){
			authReponse.setAuthorization(true);
			if(user.get().isAdmin()) {
				authReponse.setAdmin(true);
			}
		}
		return authReponse;
	}

	
}
