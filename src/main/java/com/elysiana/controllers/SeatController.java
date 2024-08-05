package com.elysiana.controllers;

import java.util.List;
import java.util.Optional;

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

import com.elysiana.entities.Seat;
import com.elysiana.payloads.ApiResponse;
import com.elysiana.payloads.SeatDto;
import com.elysiana.service.impl.SeatServiceImpl;

@RestController
@RequestMapping("/api")
public class SeatController {

	@Autowired
	SeatServiceImpl service;

	@GetMapping("/seats")
	ResponseEntity<List<SeatDto>> getAllSeats() {
		List<SeatDto> listOfSeats = service.getAllSeats();
		return new ResponseEntity<>(listOfSeats, HttpStatus.OK);
	}
   @GetMapping("/seats/{eventId}")
    ResponseEntity<List<SeatDto>> getAllSeatByEvent(@PathVariable Integer eventId)
	 {
	 List<SeatDto> listofSeat= service.getAllSeatByEvent(eventId);
	  return new ResponseEntity<> (listofSeat,HttpStatus.OK);
	  
     }
   @GetMapping("/seats/{seatId}")
   ResponseEntity <Optional<Seat>> getSeatById(@PathVariable Integer seatId)
	 {
	 Optional<Seat> listofSeat= service.getSeatById(seatId);
	  return new ResponseEntity<> (listofSeat,HttpStatus.OK);
	  
    }
	@PostMapping("/admin/events/{eventId}/seats")
	ResponseEntity<ApiResponse> createSeats(@RequestBody SeatDto seatDto , @PathVariable Integer eventId)
	{
		service.createSeats(seatDto , eventId);
		return new ResponseEntity<>(new ApiResponse("Seat created successfully", true), HttpStatus.CREATED);
		
	}

	@PutMapping("/admin/events/{eventId}/seats/{seatId}")
	ResponseEntity<ApiResponse> updateSeats(@RequestBody SeatDto seatDto,@PathVariable Integer seatId , @PathVariable Integer eventId)
		{
			service.updateSeatsById(seatDto,seatId,eventId);
			return new ResponseEntity<>(new ApiResponse("Seat updated successfully", true), HttpStatus.CREATED);
		}

	@DeleteMapping("/admin/seats/{seatId}")
	ResponseEntity<ApiResponse> deleteSeat(@PathVariable Integer seatId)
	{
		service.deleteSeatsById(seatId);
		return new ResponseEntity<>(new ApiResponse("Seat deleted successfully", true), HttpStatus.OK);
	}
	
	
}
