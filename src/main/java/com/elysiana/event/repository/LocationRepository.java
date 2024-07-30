package com.elysiana.event.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elysiana.event.entities.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
