package com.elysiana.event.service;

import java.util.List;

import com.elysiana.payloads.SeatDto;



public interface SeatService {
//	void createSeats(Seats seat);
//	void updateSeats(Seats seat);
//	void deleteSeats(Integer seatId);
	List<SeatDto> getAllSeats();
}
