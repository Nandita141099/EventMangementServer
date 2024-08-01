package com.elysiana.service;

import com.elysiana.payloads.BookingDto;

public interface BookingService {

	void getAllBookings();
	void createBooking(BookingDto bookingDto , Integer eventId);
	void updateBooking(BookingDto bookingDto, Integer eventId , Integer bookingId );
	void deleteBookingById(Integer bookingId);
}
