package com.elysiana.event.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elysiana.event.entities.Seats;

@Repository
public interface SeatRepository extends CrudRepository<Seats, Integer> {

}
