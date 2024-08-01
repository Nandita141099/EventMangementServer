package com.elysiana.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	private int noOfSeats;
	private String seatType;
	private double totalCost;
	
	@ManyToOne
	private User userId;
	
	@ManyToOne
	@JoinColumn(name="eventId")
	private Event event;
	
	
}
