package com.elysiana.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elysiana.event.service.EventServiceImpl;
import com.elysiana.payloads.EventDto;

@RestController
@RequestMapping("api/v1.0")
public class EventController {

	@Autowired
	EventServiceImpl service;

//	@GetMapping("/events/seats/{id}")
//	List<Event> getAllSeatsByEventId(@PathVariable Integer id){
//		return service.getAllSeats(id);
//	}

	@GetMapping("/events")
	ResponseEntity<List<EventDto>> getAllEvent() {
		List<EventDto> listOfEvents =  service.getAllEvents();
		return new ResponseEntity<>(listOfEvents,HttpStatus.OK);

	}
//	@PostMapping("/events")
//	void createLocation(@RequestBody EventDto eventDto)
//	{
//		service.createEventDto(eventDto);
//	}

//	@PutMapping("/events/{eventId}")
//	void updateLocation(@RequestBody Event event)
//		{
//			service.updateEvent(event);
//		}
//	
//	@DeleteMapping("/events/{eventId}")
//	void deleteLocation(@PathVariable Integer eventId)
//	{
//		service.deleteEvent(eventId);
//	}

}
