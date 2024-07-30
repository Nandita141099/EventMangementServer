package com.elysiana.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elysiana.event.entities.Seats;
import com.elysiana.event.service.SeatServiceImpl;


@RestController
@RequestMapping("api/v1.0")
public class SeatController {

	@Autowired
	SeatServiceImpl service;
	
	@GetMapping("/seats")
	List<Seats>getAllSeats()
	{
		return service.getAllSeats();
	}
	
	@PostMapping("/seats")
	void createSeats(@RequestBody Seats seat)
	{
		service.createSeats(seat);
	}
	
	@PutMapping("/seats/{seatId}")
	void updateSeats(@RequestBody Seats seat)
		{
			service.updateSeats(seat);
		}
	
	@DeleteMapping("/seats/{seatId}")
	void deleteSeat(@PathVariable Integer seatId)
	{
		service.deleteSeats(seatId);
	}
}
