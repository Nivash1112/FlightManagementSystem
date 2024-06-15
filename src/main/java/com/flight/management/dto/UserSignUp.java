package com.flight.management.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserSignUp {

	private String userName;
	private String name;
	private String email;
	private long contactNumber;
	private Date dateOfBirth;
	private String password;
	
}
