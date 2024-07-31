package com.elysiana.event.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elysiana.event.entities.Event;
import com.elysiana.event.entities.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {
	List<Location> findAll();
}
