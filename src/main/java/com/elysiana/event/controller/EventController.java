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

import com.elysiana.event.entities.Event;

import com.elysiana.event.service.EventServiceImpl;

@RestController
@RequestMapping("api/v1.0")
public class EventController {

	@Autowired
	EventServiceImpl service;
	
//	@GetMapping("/events/seats/{id}")
//	List<Event> getAllSeats(@PathVariable Integer id){
//		return service.getAllSeats(id);
//	}
	
	@GetMapping("/events")
	List<Event> getAllEvent()
	{
		return service.getAllEvent();
		
	}
	@PostMapping("/events")
	void createLocation(@RequestBody Event event)
	{
		service.createEvent(event);
	}
	
	@PutMapping("/events/{eventId}")
	void updateLocation(@RequestBody Event event)
		{
			service.updateEvent(event);
		}
	
	@DeleteMapping("/events/{eventId}")
	void deleteLocation(@PathVariable Integer eventId)
	{
		service.deleteEvent(eventId);
	}
	
}
