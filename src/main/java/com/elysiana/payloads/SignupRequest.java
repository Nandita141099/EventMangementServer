package com.elysiana.payloads;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {
	private String name;
    private String email;
    private String password;
    private String contact;
    private String roles;

}
