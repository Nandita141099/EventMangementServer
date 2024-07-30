package com.elysiana.event.service;

import java.util.List;

import com.elysiana.event.entities.Event;



public interface EventService {
	void createEvent(Event event);
	void updateEvent(Event event);
	void deleteEvent(Integer eventId);
	List<Event> getAllEvent();
}
