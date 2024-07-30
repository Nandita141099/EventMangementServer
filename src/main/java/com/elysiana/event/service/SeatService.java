package com.elysiana.event.service;

import java.util.List;

import com.elysiana.event.entities.Seats;



public interface SeatService {
	void createSeats(Seats seat);
	void updateSeats(Seats seat);
	void deleteSeats(Integer seatId);
	List<Seats> getAllSeats();
}
