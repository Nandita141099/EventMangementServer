package com.elysiana.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elysiana.payloads.SeatDto;
import com.elysiana.service.impl.SeatServiceImpl;

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

	@PostMapping("/events/{eventId}/seats")
	void createSeats(@RequestBody SeatDto seatDto , @PathVariable Integer eventId)
	{
		service.createSeats(seatDto , eventId);
	}

	@PutMapping("/events/{eventId}/seats/{seatId}")
	void updateSeats(@RequestBody SeatDto seatDto,@PathVariable Integer seatId , @PathVariable Integer eventId)
		{
			service.updateSeatsById(seatDto,seatId,eventId);
		}

	@DeleteMapping("/seats/{seatId}")
	void deleteSeat(@PathVariable Integer seatId)
	{
		service.deleteSeatsById(seatId);
	}
}
