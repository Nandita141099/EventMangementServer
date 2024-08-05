package com.elysiana.service;

import java.util.List;
import java.util.Optional;

import com.elysiana.entities.Booking;
import com.elysiana.payloads.BookingDto;

public interface BookingService {

	List<BookingDto> getAllBookings();
	void createBooking(BookingDto bookingDto , Integer eventId);
	void updateBooking(BookingDto bookingDto, Integer eventId , Integer bookingId );
	void deleteBookingById(Integer bookingId);
	
	Optional<Booking> getBookingById(Integer bookingId); // from here new
    List<BookingDto> getAllBookingByUser(Integer userId);
    List<BookingDto> getAllBookingByEvent(Integer eventId);
    
}
