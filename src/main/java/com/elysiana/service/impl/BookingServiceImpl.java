package com.elysiana.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elysiana.entities.Booking;
import com.elysiana.entities.Event;
import com.elysiana.exceptions.ResourceNotFoundException;
import com.elysiana.payloads.BookingDto;
import com.elysiana.repository.BookingRepository;
import com.elysiana.repository.EventRepository;
import com.elysiana.service.BookingService;

@Service
public class BookingServiceImpl  implements BookingService{

	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	BookingRepository bookingRepo;
	
	@Autowired
	EventRepository eventRepo;
	
	@Override
	public List<BookingDto> getAllBookings() {
		
		List<Booking> bookings = bookingRepo.findAll();
		List<BookingDto> bookingDto = bookings.stream().map(booking -> bookingToBookingDto(booking)).collect(Collectors.toList());
		return bookingDto;
	}

	@Override
	public void createBooking(BookingDto bookingDto, Integer eventId) {
		Optional<Event> event = eventRepo.findById(eventId);
		Booking booking = bookingDtoToBooking(bookingDto);
		booking.setEvent(event.get());
		bookingRepo.save(booking);

		
		
	}

	@Override
	public void updateBooking(BookingDto bookingDto, Integer eventId, Integer bookingId) {
//		Booking booking = bookingRepo.findById(bookingId).orElseThrow(() -> new ResourceNotFoundException("Booking", "Id", bookingId));
//        booking.setBookingId(bookingDto.getBookingId());
//        booking.setNoOfSeats(bookingDto.getNoOfSeats());
//        booking.setSeatType(bookingDto.getSeatType());
//        booking.setTotalCost(bookingDto.getTotalCost());
//       bookingRepo.save(booking);
//		
	}

	@Override
	public void deleteBookingById(Integer bookingId) {
		 Booking booking = bookingRepo.findById(bookingId).orElseThrow(() -> new ResourceNotFoundException("Booking", "Id", bookingId));
	       bookingRepo.delete(booking);
		
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
