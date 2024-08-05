package com.elysiana.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elysiana.entities.Booking;
import com.elysiana.entities.Event;
import com.elysiana.entities.User;
import com.elysiana.payloads.BookingDto;
import com.elysiana.payloads.LocationDto;

public interface BookingRepository extends CrudRepository<Booking, Integer> {
	
	List<Booking> findAll();
	List<BookingDto> findByEvent(Event event);
	List<BookingDto> findByUser(User user);
}