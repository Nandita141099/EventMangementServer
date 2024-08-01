package com.elysiana.payloads;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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
	
}
