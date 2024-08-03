package com.elysiana.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elysiana.entities.Event;
import com.elysiana.entities.Seat;

@Repository
public interface SeatRepository extends CrudRepository<Seat, Integer> {

	List<Seat> findAll();

	List<Seat> findByEvent(Event event);

}
