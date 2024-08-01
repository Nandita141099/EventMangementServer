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

import com.elysiana.payloads.EventDto;
import com.elysiana.payloads.SeatDto;
import com.elysiana.service.impl.EventServiceImpl;

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
	@PostMapping("/events")
	void createLocation(@RequestBody EventDto eventDto)
	{
		service.createEvent(eventDto);
	}

	@PutMapping("/events/{eventId}")
	void updateLocation(@RequestBody EventDto eventDto,@PathVariable Integer eventId)
		{
			service.updateEventById(eventDto,eventId);
		}
	
	@DeleteMapping("/events/{eventId}")
	void deleteLocation(@PathVariable Integer eventId)
	{
		service.deleteEventById(eventId);
	}

}
