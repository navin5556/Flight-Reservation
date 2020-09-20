package com.bharath.flighreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bharath.flighreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
