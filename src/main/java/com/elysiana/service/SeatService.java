package com.elysiana.service;

import java.util.List;
import java.util.Optional;

import com.elysiana.entities.Seat;
import com.elysiana.payloads.SeatDto;



public interface SeatService {
	void createSeats(SeatDto seatDto , Integer eventId );
	void updateSeatsById(SeatDto seatDto,Integer seatId, Integer eventId);
	void deleteSeatsById(Integer seatId);
	List<SeatDto> getAllSeats();
	
	List<SeatDto> getAllSeatByEvent(Integer eventId); //new
	Optional<Seat> getSeatById(Integer seatId);
}
