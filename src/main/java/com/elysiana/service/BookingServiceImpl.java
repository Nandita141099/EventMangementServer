package com.elysiana.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elysiana.entities.Booking;
import com.elysiana.entities.Event;
import com.elysiana.payloads.BookingDto;
import com.elysiana.payloads.EventDto;
import com.elysiana.repository.BookingRepository;

@Service
public class BookingServiceImpl  implements BookingService{

	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	BookingRepository bookingRepo;
	
	@Override
	public void getAllBookings() {
		
		
	}

	@Override
	public void createBooking(BookingDto bookingDto, Integer eventId) {
		
		
		
	}

	@Override
	public void updateBooking(BookingDto bookingDto, Integer eventId, Integer bookingId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBookingById(Integer bookingId) {
		// TODO Auto-generated method stub
		
	}
	private Booking bookingDtoToBooking(BookingDto bookingDto) {
        Booking booking = modelMapper.map(bookingDto, Booking.class);
        return booking;
    }
    public BookingDto bookingToBookingDto(Booking booking) {
        BookingDto bookingDto = modelMapper.map(booking, BookingDto.class);
        return bookingDto;
    }

}
