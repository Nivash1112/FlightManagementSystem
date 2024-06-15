package com.flight.management.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.management.dto.UserSignUp;
import com.flight.management.exception.UserAlreadyFoundException;
import com.flight.management.model.UserModel;
import com.flight.management.repository.UserRepository;
import com.flight.management.service.UserService;
import com.flight.management.utils.ConvertUserDtoToUserModel;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ConvertUserDtoToUserModel userDtoToModel;
	
	@Override
	public boolean createUser(UserSignUp userDetails) throws UserAlreadyFoundException{
		
		Optional<UserModel> userFound= userRepo.findById(userDetails.getUserName());
		if(userFound.isEmpty()) {
			UserModel response=userRepo.save(userDtoToModel.convertUserDtoToUserModel(userDetails));
			return (response!=null)?true:false;
		}else {
			throw new UserAlreadyFoundException("User Already Found Exception...!");
		}
	}

	@Override
	public Optional<UserModel> findByUsername(String username) {
		return userRepo.findById(username);
	
	}

}
