package com.elysiana.event.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.elysiana.event.entities.Location;

@Service
public interface LocationService {
	void createLocation(Location location);
	void updateLocation(Location location);
	void deleteLocation(Integer locationId);
	List<Location> getAllLocation();
}
