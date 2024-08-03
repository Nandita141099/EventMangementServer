package com.elysiana.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	private Integer locationId;
	private String place;
	private String city;
	private String state;
	private Integer pincode;
	
	  @OneToOne
	  @JoinColumn(name="eventId")
	  private Event event;
}
