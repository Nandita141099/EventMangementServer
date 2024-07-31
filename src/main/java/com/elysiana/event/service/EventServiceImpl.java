package com.elysiana.event.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elysiana.event.entities.Event;
import com.elysiana.event.repository.EventRepository;
import com.elysiana.payloads.EventDto;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventRepository eventRepo;
	
	@Autowired
    private ModelMapper modelMapper;
	
//	@Autowired
//	SeatRepository seatRepo;
//	
//	public List<Event> getAllSeats(Integer id){
//        return  (List<Event>) eventRepo.findBySeatSeatId(id);
//    }
	@Override
	public void createEvent(EventDto eventDto) {
		Event event= eventDtoToEvent(eventDto);
		eventRepo.save(event);
		
	}

//	@Override
//	public void updateEvent(EventDto event) {
//		
//		
//		Event event = eventRepo.findById(eventId).orElseThrow(() -> new ResourceNotFoundException("Event", "Id", eventId));
//        event.setUserName(eventDto.getUserName());
//        user.setEmailId(userDto.getEmailId());
//        user.setPassword(userDto.getPassword());
//        user.setBio(userDto.getBio());
//       eventRepo.save(event);
//	}

//	@Override
//	public void deleteEvent(Integer eventId) {
//		eventRepo.deleteById(eventId);
//	}

	@Override
	public List<EventDto> getAllEvents() {
		  List<Event> events = eventRepo.findAll();
	        List<EventDto> eventDtos = events.stream().map(event -> eventToEventDto(event)).collect(Collectors.toList());
	        return eventDtos;
		
	}
	
	private Event eventDtoToEvent(EventDto eventDto) {
        Event event = modelMapper.map(eventDto, Event.class);
        return event;
    }
    public EventDto eventToEventDto(Event event) {
        EventDto eventDto = modelMapper.map(event, EventDto.class);
        return eventDto;
    }
	
}
