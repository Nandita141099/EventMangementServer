package com.elysiana.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elysiana.event.service.SeatServiceImpl;
import com.elysiana.payloads.SeatDto;

@RestController
@RequestMapping("api/v1.0")
public class SeatController {

	@Autowired
	SeatServiceImpl service;

	@GetMapping("/seats")
	ResponseEntity<List<SeatDto>> getAllSeats() {
		List<SeatDto> listOfSeats = service.getAllSeats();
		return new ResponseEntity<>(listOfSeats, HttpStatus.OK);
	}

//	@PostMapping("/seats")
//	void createSeats(@RequestBody Seats seat)
//	{
//		service.createSeats(seat);
//	}

//	@PutMapping("/seats/{seatId}")
//	void updateSeats(@RequestBody Seats seat)
//		{
//			service.updateSeats(seat);
//		}
//	
//	@DeleteMapping("/seats/{seatId}")
//	void deleteSeat(@PathVariable Integer seatId)
//	{
//		service.deleteSeats(seatId);
//	}
}
