
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

import com.elysiana.entities.Booking;
import com.elysiana.payloads.BookingDto;
import com.elysiana.payloads.SeatDto;
import com.elysiana.service.impl.BookingServiceImpl;

@RestController
@RequestMapping("/api")
public class BookingController {

		@Autowired
		BookingServiceImpl service;

		@GetMapping("/bookings")
		ResponseEntity<List<BookingDto>> getAllBooking() {
			List<BookingDto> listOfBooking = service.getAllBookings();
			return new ResponseEntity<>(listOfBooking, HttpStatus.OK);
		}
		
		@GetMapping("/booking/{bookingId}")
		ResponseEntity <Optional<Booking>> getBookingById(@PathVariable  Integer bookingId)
		{
			Optional<Booking> listOfBooking = service.getBookingById(bookingId);
			return new ResponseEntity<>(listOfBooking, HttpStatus.OK);
		}
		@GetMapping("/booking/{eventId}")
	    ResponseEntity<List<BookingDto>> getAllBookingByEvent(@PathVariable Integer eventId)
		 {
		 List<BookingDto> listofBooking= service.getAllBookingByEvent(eventId);
		  return new ResponseEntity<> (listofBooking,HttpStatus.OK);
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
