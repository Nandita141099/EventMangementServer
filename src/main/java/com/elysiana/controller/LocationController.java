package com.elysiana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elysiana.payloads.LocationDto;
import com.elysiana.service.impl.LocationServiceImpl;

@RestController
@RequestMapping("api/v1.0")
public class LocationController {

	@Autowired
	LocationServiceImpl service;

	@GetMapping("/locations")
	ResponseEntity<List<LocationDto>> getAllEvent() {
		List<LocationDto> listOflocation = service.getAllLocations();
		return new ResponseEntity<>(listOflocation, HttpStatus.OK);
	}
	

	@PostMapping("/events/{eventId}/locations")
	void createLocation(@RequestBody LocationDto locationDto , @PathVariable  Integer eventId)
	{
		service.createLocation(locationDto, eventId);
	}
	
	@PutMapping("events/{eventId}/locations/{locationId}")
	void updateLocation(@RequestBody LocationDto locationDto ,@PathVariable Integer locationId,@PathVariable Integer eventId)
		{
			service.updateLocationById(locationDto,locationId, eventId);
		}
	
	@DeleteMapping("/locations/{locationId}")
	void deleteLocation(@PathVariable Integer locationId)
	{
		service.deleteLocationById(locationId);
	}

}
