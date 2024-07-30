package com.elysiana.Event;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int locationId;
	private String place;
	private String city;
	private String state;
	private int pincode;
	
	@OneToOne
	@JoinColumn(name="eventId")
	private Event event;
	
}
