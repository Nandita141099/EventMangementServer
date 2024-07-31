package com.elysiana.event.UserController;

import java.util.List;
import java.util.Map;

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

import com.elysiana.event.ApiResponse.ApiResponse;
import com.elysiana.event.UserService.UserService;
import com.elysiana.event.Userdto.UserDto;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userservice;
	@PostMapping("/")
	public ResponseEntity<UserDto>createUser(@RequestBody UserDto userDto){
		UserDto createUserDto=this.userservice.createUser(userDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<UserDto>updateUser(@RequestBody UserDto userDto,@PathVariable("id") Integer id1){
		UserDto  updatedUser=this.userservice.updateUser(userDto,id1);
		return ResponseEntity.ok(updatedUser);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse>deleteUser(@PathVariable("id") Integer id1){
		this.userservice.deleteUser(id1);
		return new  ResponseEntity(new ApiResponse("user deleted sucessfully",true),HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<List<UserDto>>getAllUser(){
		return ResponseEntity.ok(this.userservice.getAllUser());
	}
	@GetMapping("/{id}")
	public ResponseEntity<UserDto>getSingleUser(@PathVariable Integer id){
		return  ResponseEntity.ok(this.userservice.getUserById(id));
	}
	
	
	
	
	
	
	
	
	
	

}
