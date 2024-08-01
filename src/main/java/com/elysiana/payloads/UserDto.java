package com.elysiana.payloads;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor

public class UserDto {
	private int id;
	private String name;
	private String  email;
	private String password;
	private String contact;
	private String roles;

}
