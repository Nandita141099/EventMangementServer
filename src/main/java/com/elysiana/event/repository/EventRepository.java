package com.elysiana.event.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elysiana.event.entities.Event;
import com.elysiana.event.entities.Seats;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
	
	List<Seats> findByEventId(Integer eventId);
}
