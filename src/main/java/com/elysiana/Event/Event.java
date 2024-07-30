package com.elysiana.Event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eventId;
	private String eventType; // like conferenece or conceret
	private String title;
	private String description;
	private LocalDate eventDate;
	private LocalTime eventTime;
 
	@OneToMany(mappedBy = "event", cascade=CascadeType.ALL)
	private List<Seats> seat;

	@OneToOne(mappedBy = "event", cascade=CascadeType.ALL)
	private Location eventLocation;

}
