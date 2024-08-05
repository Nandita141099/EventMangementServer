package com.elysiana.service;

import java.util.List;
import java.util.Optional;

import com.elysiana.entities.Event;
import com.elysiana.payloads.EventDto;

public interface EventService {
	void createEvent(EventDto eventDto, String email);

	void updateEventById(EventDto eventDto, Integer eventId);

	void deleteEventById(Integer eventId);

	List<EventDto> getAllEvents();

	List<EventDto> getAllEventsByUserEmail(String email);
	
	Optional<Event> getEventById(Integer eventId);
}
