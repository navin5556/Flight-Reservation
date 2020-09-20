package com.bharath.flighreservation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bharath.flighreservation.controllers.ReservationController;
import com.bharath.flighreservation.dto.ReservationRequest;
import com.bharath.flighreservation.entities.Flight;
import com.bharath.flighreservation.entities.Passenger;
import com.bharath.flighreservation.entities.Reservation;
import com.bharath.flighreservation.repos.FlightRepository;
import com.bharath.flighreservation.repos.PassengerRepository;
import com.bharath.flighreservation.repos.ReservationRepository;
import com.bharath.flighreservation.util.EmailUtil;
import com.bharath.flighreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository flightRepository;
	@Autowired
	PassengerRepository passengerRepository;
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	PDFGenerator pdfGenerator;
	@Autowired
	EmailUtil emailUtil;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		LOGGER.info("inside bookFlight()");

		Long flightId = request.getFlightId();
		LOGGER.info("fetching flight for flight id "+flightId);
		Flight flight = flightRepository.findById(flightId).orElse(new Flight());

		Passenger passenger = new Passenger();
		passenger.setFirstname(request.getPassengerFirstName());
		passenger.setLastname(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		LOGGER.info("saving the passenger "+passenger);
		Passenger savedPassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		LOGGER.info("saving the reservation "+reservation);
		Reservation savedReservation = reservationRepository.save(reservation);
 
		String filePath = "C:/Users/NAVIN SINGH/Documents/flight/flight"+savedReservation.getId()+".pdf";
		LOGGER.info("generation the itinerary ");
		pdfGenerator.generateItinerary(savedReservation, filePath);
		LOGGER.info("emailing the itinerary ");
		emailUtil.sendItinerary(passenger.getEmail(), filePath);
		
		return savedReservation;
	}

}
