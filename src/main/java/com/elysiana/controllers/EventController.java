package com.elysiana.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elysiana.config.JwtUtil;
import com.elysiana.entities.Event;
import com.elysiana.payloads.ApiResponse;
import com.elysiana.payloads.EventDto;
import com.elysiana.service.impl.EventServiceImpl;

@RestController
@RequestMapping("/api")
public class EventController {

	@Autowired
	EventServiceImpl service;

	@Autowired
	JwtUtil jwtUtil;

	@GetMapping("/events")
	ResponseEntity<List<EventDto>> getAllEvents() {
		List<EventDto> listOfEvents = service.getAllEvents();
		return new ResponseEntity<>(listOfEvents, HttpStatus.OK);
	}

	@GetMapping("/admin/events")
	ResponseEntity<List<EventDto>> getAllEventsByUser(@RequestHeader("Authorization") String token) {
		String jwt = token.substring(7);
		String email = jwtUtil.extractEmail(jwt);
		List<EventDto> events = service.getAllEventsByUserEmail(email);
		return new ResponseEntity<>(events, HttpStatus.OK);
	}
	
	@GetMapping("/events/{eventId}")
	ResponseEntity<Optional<Event>> getEventById(@PathVariable Integer eventId) {
		Optional<Event> event = service.getEventById(eventId);
		return new ResponseEntity<>(event, HttpStatus.OK);
	}
	@PostMapping("/admin/events")
	ResponseEntity<ApiResponse> createEvent(@RequestHeader("Authorization") String token,
			@RequestBody EventDto eventDto) {

		String jwt = token.substring(7);
		String email = jwtUtil.extractEmail(jwt);
		service.createEvent(eventDto,email);
		return new ResponseEntity<>(new ApiResponse("Event created successfully", true), HttpStatus.CREATED);
	}

	@PutMapping("/admin/events/{eventId}")
	ResponseEntity<ApiResponse> updateEventById(@RequestBody EventDto eventDto, @PathVariable Integer eventId) {
		service.updateEventById(eventDto, eventId);
		return new ResponseEntity<>(new ApiResponse("Event updated successfully", true), HttpStatus.CREATED);
	}

	@DeleteMapping("/admin/events/{eventId}")
	ResponseEntity<ApiResponse> deleteEventById(@PathVariable Integer eventId) {
		service.deleteEventById(eventId);
		return new ResponseEntity<>(new ApiResponse("Event deleted successfully", true), HttpStatus.OK);
	}

}
