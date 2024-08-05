package com.elysiana.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elysiana.entities.Event;
import com.elysiana.entities.User;
import com.elysiana.exceptions.ResourceNotFoundException;
import com.elysiana.payloads.EventDto;
import com.elysiana.repository.EventRepository;
import com.elysiana.repository.UserRepository;
import com.elysiana.service.EventService;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventRepository eventRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void createEvent(EventDto eventDto, String email) {
		User user = userRepo.findByEmail(email);
		Event event = eventDtoToEvent(eventDto);
		event.setUser(user);
		eventRepo.save(event);
	}

	@Override
	public void updateEventById(EventDto eventDto, Integer eventId) {

		Event event = eventRepo.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Event", "Id", eventId));
		event.setEventId(eventDto.getEventId());
		event.setEventType(eventDto.getEventType());
		event.setTitle(eventDto.getTitle());
		event.setDescription(eventDto.getDescription());
		event.setEventDate(eventDto.getEventDate());
		event.setEventTime(eventDto.getEventTime());

		eventRepo.save(event);
	}

	@Override
	public void deleteEventById(Integer eventId) {
		Event event = eventRepo.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Event", "Id", eventId));
		eventRepo.delete(event);
	}

	@Override
	public List<EventDto> getAllEvents() {
		List<Event> events = eventRepo.findAll();
		List<EventDto> eventDtos = events.stream().map(event -> eventToEventDto(event)).collect(Collectors.toList());
		return eventDtos;

	}

	@Override
	public List<EventDto> getAllEventsByUserEmail(String email) {
		User user = userRepo.findByEmail(email);
		List<Event> events = eventRepo.findByUser(user);

		return events.stream().map(event -> eventToEventDto(event)).collect(Collectors.toList());
	}

	private Event eventDtoToEvent(EventDto eventDto) {
		Event event = modelMapper.map(eventDto, Event.class);
		return event;
	}

	public EventDto eventToEventDto(Event event) {
		EventDto eventDto = modelMapper.map(event, EventDto.class);
		return eventDto;
	}

	@Override
	public Optional<Event> getEventById(Integer eventId) {
		Event event = eventRepo.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Event", "id", eventId));
		return eventRepo.findById(eventId);
	}

}
