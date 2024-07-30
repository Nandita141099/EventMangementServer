package com.elysiana.event.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seats {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int seatId;
	private int capacity;
	private double price;
	private String seatType;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="eventId") private Event event;
	 */
	 

}
