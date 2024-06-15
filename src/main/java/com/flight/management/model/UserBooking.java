package com.flight.management.model;

import java.sql.Date;

import javax.persistence.Id;

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
public class UserBooking {

	@Id
	private int bookingId;
	private int flightId;
	private Date journeyDate;
	private boolean bookingDone;
	
}
