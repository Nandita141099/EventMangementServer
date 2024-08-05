package com.elysiana.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elysiana.entities.Event;
import com.elysiana.entities.Seat;
import com.elysiana.exceptions.ResourceNotFoundException;
import com.elysiana.payloads.SeatDto;
import com.elysiana.repository.EventRepository;
import com.elysiana.repository.SeatRepository;
import com.elysiana.service.SeatService;

@Service
public class SeatServiceImpl implements SeatService {

	@Autowired
	SeatRepository seatRepo;
	
	@Autowired
	EventRepository eventRepo;

	@Autowired
	private ModelMapper modelMapper;



	@Override
	public List<SeatDto> getAllSeats() {

		List<Seat> seats = seatRepo.findAll();
		List<SeatDto> seatDto = seats.stream().map(seat -> seatToSeatDto(seat)).collect(Collectors.toList());
		return seatDto;
	}

	private Seat seatDtoToSeats(SeatDto seatDto) {
		Seat seat = modelMapper.map(seatDto, Seat.class);
		return seat;
	}

	public SeatDto seatToSeatDto(Seat seat) {
		SeatDto seatDto = modelMapper.map(seat, SeatDto.class);
		return seatDto;
	}

	@Override
	public void createSeats(SeatDto seatDto , Integer eventId) {
		Optional<Event> event = eventRepo.findById(eventId);
		Seat seat = seatDtoToSeats(seatDto);
		seat.setEvent(event.get());
		seatRepo.save(seat);
		
	}

	@Override
	public void updateSeatsById(SeatDto seatDto,Integer seatId, Integer eventId){
		Optional<Event> event = eventRepo.findById(eventId);
		Seat seat = seatRepo.findById(seatId).orElseThrow(() -> new ResourceNotFoundException("Seat", "Id", seatId));
        seat.setSeatId(seatDto.getSeatId());
        seat.setCapacity(seatDto.getCapacity());
        seat.setSeatType(seatDto.getSeatType());
        seat.setPrice(seatDto.getPrice());
       seatRepo.save(seat);
		}

	@Override
	public void deleteSeatsById(Integer seatId) {
		 Seat seat = seatRepo.findById(seatId).orElseThrow(() -> new ResourceNotFoundException("Seat", "Id", seatId));
	       seatRepo.delete(seat);
		
	}

	@Override
	public List<SeatDto> getAllSeatByEvent(Integer eventId) {
		Event event = eventRepo.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Event", "id", eventId));
		return seatRepo.findByEvent(event);
	}

	@Override
	public Optional<Seat> getSeatById(Integer seatId) {
		
		Seat seat = seatRepo.findById(seatId).orElseThrow(() -> new ResourceNotFoundException("Seat", "Id", seatId));
		return seatRepo.findById(seatId);
		
	}
}
