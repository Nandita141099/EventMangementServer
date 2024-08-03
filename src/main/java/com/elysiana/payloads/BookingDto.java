package com.elysiana.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
	private int bookingId;
	private int noOfSeats;
	private String seatType;
	private double totalCost;

}
