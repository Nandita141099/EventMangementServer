package com.elysiana.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elysiana.event.entities.Location;
import com.elysiana.event.service.LocationServiceImpl;

@RestController
@RequestMapping("api/v1.0")
public class LocationController {

	
	@Autowired
	LocationServiceImpl service;
	
	@GetMapping("/locations")
	List<Location>getAllLocations()
	{
		return service.getAllLocation();
	}
	
	@PostMapping("/locations")
	void createLocation(@RequestBody Location location)
	{
		service.createLocation(location);
	}
	
	@PutMapping("/locations/{locationId}")
	void updateLocation(@RequestBody Location location)
		{
			service.updateLocation(location);
		}
	
	@DeleteMapping("/locations/{locationId}")
	void deleteLocation(@PathVariable Integer locationId)
	{
		service.deleteLocation(locationId);
	}
	
	
}
