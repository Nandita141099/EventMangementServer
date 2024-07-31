package com.elysiana.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatDto {

	private int seatId;
	private int capacity;
	private double price;
	private String seatType;

//	private EventDto event;
}
