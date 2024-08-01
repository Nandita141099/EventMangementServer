package com.elysiana.service;

import java.util.List;

import com.elysiana.payloads.BookingDto;

public interface BookingService {

	List<BookingDto> getAllBookings();
	void createBooking(BookingDto bookingDto , Integer eventId);
	void updateBooking(BookingDto bookingDto, Integer eventId , Integer bookingId );
	void deleteBookingById(Integer bookingId);
}
