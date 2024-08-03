package com.elysiana.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
	private String jwt;
	private int userId;
	private String name;
	private String email;
	private String contact;
	private String role;

}
