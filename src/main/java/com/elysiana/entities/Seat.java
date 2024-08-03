package com.elysiana.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer seatId;
	private Integer capacity;
	private double price;
	private String seatType;

	@ManyToOne
	@JoinColumn(name = "eventId")
	private Event event;

	@OneToMany(mappedBy = "seat", cascade = CascadeType.ALL)
	private List<Booking> booking;

}
