package com.elysiana.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elysiana.event.entities.Location;
import com.elysiana.event.repository.LocationRepository;


@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	LocationRepository locationRepo;

	@Override
	public void createLocation(Location location) {
		locationRepo.save(location);
	}

	@Override
	public void updateLocation(Location location) {
		locationRepo.save(location);

	}

	@Override
	public void deleteLocation(Integer locationId) {
		locationRepo.deleteById(locationId);

	}

	@Override
	public List<Location> getAllLocation() {
		
		return (List<Location>) locationRepo.findAll();
	}
}
