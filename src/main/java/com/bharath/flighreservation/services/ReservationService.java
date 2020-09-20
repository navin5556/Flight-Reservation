package com.bharath.flighreservation.services;

import com.bharath.flighreservation.dto.ReservationRequest;
import com.bharath.flighreservation.entities.Reservation;

public interface ReservationService {

	public Reservation bookFlight(ReservationRequest request);
}
