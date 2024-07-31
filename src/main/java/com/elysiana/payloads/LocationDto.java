package com.elysiana.payloads;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {
	private int locationId;
	private String place;
	private String city;
	private String state;
	private int pincode;
}
