package com.elysiana.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elysiana.entities.Booking;
import com.elysiana.entities.Event;

public interface BookingRepository extends CrudRepository<Booking, Integer> {
	List<Booking> findAll();
}