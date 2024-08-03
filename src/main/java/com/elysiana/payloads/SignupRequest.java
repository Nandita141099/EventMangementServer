package com.elysiana.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
	private String name;
    private String email;
    private String password;
    private String contact;
    private String role;

}
