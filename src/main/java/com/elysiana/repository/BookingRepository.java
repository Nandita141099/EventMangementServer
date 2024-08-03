package com.elysiana.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elysiana.entities.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer> {
	
	List<Booking> findAll();
}