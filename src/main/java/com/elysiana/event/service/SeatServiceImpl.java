package com.elysiana.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elysiana.event.entities.Seats;
import com.elysiana.event.repository.SeatRepository;


@Service
public class SeatServiceImpl implements SeatService {

	@Autowired
	SeatRepository seatRepo;

	
	@Override
	public void createSeats(Seats seat) {
		seatRepo.save(seat);
		}

	@Override
	public void updateSeats(Seats seat) {
		seatRepo.save(seat);

	}

	@Override
	public void deleteSeats(Integer seatId) {
		seatRepo.deleteById(seatId);

	}

	@Override
	public List<Seats> getAllSeats() {
		
		return  (List<Seats>) seatRepo.findAll();
	}

}
