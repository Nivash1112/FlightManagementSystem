package com.flight.management.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserModel {

	@Id
	private String userId;
	
	private String name;
	private String email;
	private long contactNumber;
	private Date dateOfBirth;
	private String password;
}
