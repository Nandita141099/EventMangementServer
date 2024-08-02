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
import com.elysiana.payloads.EventDto;
import com.elysiana.service.impl.EventServiceImpl;

@RestController
@RequestMapping("/api")
public class EventController {

	@Autowired
	EventServiceImpl service;

	@GetMapping("/events")
	ResponseEntity<List<EventDto>> getAllEvent() {
		List<EventDto> listOfEvents = service.getAllEvents();
		return new ResponseEntity<>(listOfEvents, HttpStatus.OK);

	}

	@PostMapping("/admin/events")
	ResponseEntity<ApiResponse> createEvent(@RequestBody EventDto eventDto) {
		service.createEvent(eventDto);
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
