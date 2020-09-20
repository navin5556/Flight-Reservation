package com.bharath.flighreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bharath.flighreservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
