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
public class FlightDetails {

	@Id
	private int flightId;
	private String flightName;
	private String vendor;
	private long price;
	private String from;
	private String to;
	private Date date;
	
}
