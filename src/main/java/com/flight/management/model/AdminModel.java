package com.flight.management.model;

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
public class AdminModel {

	@Id
	private String userId;
	
	private String name;
	private String email;
	private long contactNumber;
	private int dateOfBirth;
	private String password;
}
