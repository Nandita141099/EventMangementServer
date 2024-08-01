package com.elysiana.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
	private int bookingId;
	private int noOfSeats;
	private String seatType;
	private double totalCost;
	
}
