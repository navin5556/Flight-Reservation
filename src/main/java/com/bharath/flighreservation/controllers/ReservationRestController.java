package com.bharath.flighreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bharath.flighreservation.dto.ReservationUpdateRequest;
import com.bharath.flighreservation.entities.Reservation;
import com.bharath.flighreservation.repos.ReservationRepository;
import com.bharath.flighreservation.services.ReservationServiceImpl;

@RestController
public class ReservationRestController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	@Autowired
	ReservationRepository reservationRepository;

	@RequestMapping("/reservations/{id}")
	public Reservation findreservation(@PathVariable("id") Long id) { 
		
		LOGGER.info("inside findreservation() for id "+id);
		Reservation reservation = reservationRepository.findById(id).orElse(new Reservation());
		return reservation;

	}
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		
		LOGGER.info("inside find updateReservation() for  "+request);
		
		Reservation reservation = reservationRepository.findById(request.getId()).orElse(new Reservation());
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		Reservation updatedReservation = reservationRepository.save(reservation);
		
		LOGGER.info("saving Reservation() for");
		
		return updatedReservation;
		
	}

}
