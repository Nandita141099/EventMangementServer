package com.elysiana.Event;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SeatsRepository {

	public interface PlaceRepository extends CrudRepository<Seats, Integer> 
	{
		
	}
}
