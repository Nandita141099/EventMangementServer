package com.elysiana.event.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elysiana.event.entities.Seat;
import com.elysiana.event.repository.SeatRepository;
import com.elysiana.payloads.SeatDto;

@Service
public class SeatServiceImpl implements SeatService {

	@Autowired
	SeatRepository seatRepo;

	@Autowired
	private ModelMapper modelMapper;

//	@Override
//	public void createSeats(Seats seat) {
//		seatRepo.save(seat);
//		}
//
//	@Override
//	public void updateSeats(Seats seat) {
//		seatRepo.save(seat);
//
//	}
//
//	@Override
//	public void deleteSeats(Integer seatId) {
//		seatRepo.deleteById(seatId);
//
//	}

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
}
