package com.elysiana.controller;

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

import com.elysiana.payloads.BookingDto;
import com.elysiana.service.impl.BookingServiceImpl;

@RestController
@RequestMapping("api/v1.0")
public class BookingController {
	
	

		@Autowired
		BookingServiceImpl service;

		@GetMapping("/bookings")
		ResponseEntity<List<BookingDto>> getAllBooking() {
			List<BookingDto> listOfBooking = service.getAllBookings();
			return new ResponseEntity<>(listOfBooking, HttpStatus.OK);
		}
		

		@PostMapping("/events/{eventId}/bookings")
		void createBooking(@RequestBody BookingDto bookingDto , @PathVariable  Integer eventId)
		{
			service.createBooking(bookingDto, eventId);
		}
		
		@PutMapping("events/{eventId}/bookings/{bookingId}")
		void updateBooking(@RequestBody BookingDto bookingDto ,@PathVariable Integer locationId,@PathVariable Integer bookingId)
			{
				service.updateBooking(bookingDto,locationId, bookingId);
			}
		
		@DeleteMapping("/bookings/{bookingId}")
		void deleteLocation(@PathVariable Integer bookingId)
		{
			service.deleteBookingById(bookingId);
		}
}
