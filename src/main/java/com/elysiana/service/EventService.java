package com.elysiana.service;

import java.util.List;

import com.elysiana.payloads.EventDto;




public interface EventService {
	void createEvent(EventDto eventDto);
	void updateEventById(EventDto eventDto,Integer eventId);
	void deleteEventById(Integer eventId);
	List<EventDto> getAllEvents();
}
