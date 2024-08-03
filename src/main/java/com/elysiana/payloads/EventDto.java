package com.elysiana.payloads;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
	
	private int eventId;
	private String eventType; 
	private String title;
	private String description;
	private LocalDate eventDate;
	private LocalTime eventTime;
  
	private List<SeatDto> seats;
	private  LocationDto location;
	private List<BookingDto> booking;
	
}
