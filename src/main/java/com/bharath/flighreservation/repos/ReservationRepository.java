package com.bharath.flighreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bharath.flighreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
