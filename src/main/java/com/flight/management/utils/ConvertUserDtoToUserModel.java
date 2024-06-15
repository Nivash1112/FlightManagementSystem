package com.flight.management.utils;

import org.springframework.stereotype.Service;

import com.flight.management.dto.UserSignUp;
import com.flight.management.model.UserModel;

@Service
public class ConvertUserDtoToUserModel {

	private UserModel userModel=new UserModel();
	
	public UserModel convertUserDtoToUserModel(UserSignUp userDto) {
		userModel.setUserId(userDto.getUserName());
		userModel.setName(userDto.getName());
		userModel.setEmail(userDto.getEmail());
		userModel.setDateOfBirth(userDto.getDateOfBirth());
		userModel.setPassword(userDto.getPassword());
		userModel.setContactNumber(userDto.getContactNumber());
		userModel.setAdmin(false);
		return userModel;
	}
	
}
