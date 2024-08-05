package com.elysiana.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elysiana.entities.Event;
import com.elysiana.entities.Location;
import com.elysiana.entities.Review;
import com.elysiana.payloads.LocationDto;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {
	
	List<Location> findAll();
	LocationDto findByEvent(Event event);
	
}
