package com.flight.management.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddFlightReq {

	private int flightId;
	private String flightName;
	private String vendor;
	private long price;
	private String fromPlace;
	private String toDestination;
	private Date journeyDate;
}
