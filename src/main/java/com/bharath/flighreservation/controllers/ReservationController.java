package com.bharath.flighreservation.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bharath.flighreservation.dto.ReservationRequest;
import com.bharath.flighreservation.entities.Flight;
import com.bharath.flighreservation.entities.Reservation;
import com.bharath.flighreservation.repos.FlightRepository;
import com.bharath.flighreservation.services.ReservationService;

@Controller
public class ReservationController {

	private static final Logger LOGGER=LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	ReservationService reservationService;

	@RequestMapping("showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		
		LOGGER.info("inside showCompleteReservation() invoked with the flight id :"+flightId);
		
		Flight flight = flightRepository.findById(flightId).orElse(new Flight());
		modelMap.addAttribute("flight", flight);
		LOGGER.info("flight is"+flight);
		return "completeReservation";
	}

	@RequestMapping(value = "completeReservation", method = RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		
		LOGGER.info("inside completeReservation()"+request);
		
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Reservatin created successfully and the id is " + reservation.getId());
		return "reservationConfirmation";

	}
}
