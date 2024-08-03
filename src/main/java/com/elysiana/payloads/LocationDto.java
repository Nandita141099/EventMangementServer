package com.elysiana.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {
	private int locationId;
	private String place;
	private String city;
	private String state;
	private int pincode;
}
