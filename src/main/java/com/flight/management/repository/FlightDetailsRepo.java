package com.flight.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.management.model.FlightDetails;

public interface FlightDetailsRepo extends JpaRepository<FlightDetails, Integer> {

}
