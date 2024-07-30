package com.elysiana.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elysiana.event.entities.Event;
import com.elysiana.event.entities.Seats;
import com.elysiana.event.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventRepository eventRepo;
	
	List<Seats> getAllSeatsByEventId(Integer eventId){
        return  eventRepo.findByEventId(eventId);
    }
	@Override
	public void createEvent(Event event) {
		eventRepo.save(event);
		
	}

	@Override
	public void updateEvent(Event event) {
		eventRepo.save(event);
		
	}

	@Override
	public void deleteEvent(Integer eventId) {
		eventRepo.deleteById(eventId);
	}

	@Override
	public List<Event> getAllEvent() {
		return (List<Event>) eventRepo.findAll();
	}

	
}
