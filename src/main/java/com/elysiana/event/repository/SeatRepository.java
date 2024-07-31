package com.elysiana.event.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elysiana.event.entities.Seat;

@Repository
public interface SeatRepository extends CrudRepository<Seat, Integer> {
	List<Seat> findAll();
}
