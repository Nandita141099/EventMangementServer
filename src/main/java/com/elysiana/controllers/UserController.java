package com.elysiana.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elysiana.payloads.ApiResponse;
import com.elysiana.payloads.SeatDto;
import com.elysiana.payloads.UserDto;
import com.elysiana.service.UserService;
import com.elysiana.service.impl.SeatServiceImpl;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> listOfusers = service.getAllUsers();
		return new ResponseEntity<>(listOfusers, HttpStatus.OK);
	}
	
	@GetMapping("/users/{userId}")
	 UserDto getUserById(@PathVariable Integer userId) {
		UserDto listOfuser = service.getUserById(userId);
		return listOfuser;
	}

	@PostMapping("/users")
	void createUser(@RequestBody UserDto userDto)
	{
		service.createUser(userDto);
	}

	@PutMapping("/user/{userId}")
	void updateUser(@RequestBody UserDto userDto,@PathVariable Integer userId )
		{
			service.updateUserById(userDto,userId);
		}

	@DeleteMapping("/users/{userId}")
	void deleteUser(@PathVariable Integer userId)
	{
		service.deleteUser(userId);
	}
	
	
	
	
	
	
	
	
	

}
