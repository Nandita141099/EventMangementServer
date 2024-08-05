package com.elysiana.controllers;

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

import com.elysiana.payloads.ApiResponse;
import com.elysiana.payloads.LocationDto;
import com.elysiana.service.impl.LocationServiceImpl;

@RestController
@RequestMapping("/api")
public class LocationController {

	@Autowired
	LocationServiceImpl service;

	@GetMapping("/locations")
	ResponseEntity<List<LocationDto>> getAllEvent() {
		List<LocationDto> listOflocation = service.getAllLocations();
		return new ResponseEntity<>(listOflocation, HttpStatus.OK);
	}
	@GetMapping("/locations/{eventId}")
	ResponseEntity<LocationDto> getLocationByEventId(@PathVariable  Integer eventId)
	{
		LocationDto location = service.getLocationByEventId(eventId);
		return new ResponseEntity (location , HttpStatus.OK);
	}

	@PostMapping("/admin/events/{eventId}/locations")
	ResponseEntity<ApiResponse> createLocation(@RequestBody LocationDto locationDto , @PathVariable  Integer eventId)
	{
		service.createLocation(locationDto, eventId);
	return	new ResponseEntity<>(new ApiResponse("Location created successfully", true), HttpStatus.CREATED);
	}
	
	@PutMapping("/admin/events/{eventId}/locations/{locationId}")
	ResponseEntity<ApiResponse> updateLocation(@RequestBody LocationDto locationDto ,@PathVariable Integer locationId,@PathVariable Integer eventId)
		{
			service.updateLocationById(locationDto,locationId, eventId);
		return	new ResponseEntity<>(new ApiResponse("Location updated successfully", true), HttpStatus.CREATED);
		}
	
	@DeleteMapping("/admin/locations/{locationId}")
	ResponseEntity<ApiResponse> deleteLocation(@PathVariable Integer locationId)
	{
		service.deleteLocationById(locationId);
		return new ResponseEntity<>(new ApiResponse("Location deleted successfully", true), HttpStatus.OK);
	}

}
