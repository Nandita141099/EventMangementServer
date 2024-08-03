package com.elysiana.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatDto {

	private int seatId;
	private int capacity;
	private double price;
	private String seatType;
}
