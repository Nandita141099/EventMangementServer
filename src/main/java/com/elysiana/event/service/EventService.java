package com.elysiana.event.service;

import java.util.List;

import com.elysiana.payloads.EventDto;




public interface EventService {
	void createEvent(EventDto eventDto);
//	void updateEvent(EventDto eventDto);
//	void deleteEvent(Integer eventId);
	List<EventDto> getAllEvents();
}
