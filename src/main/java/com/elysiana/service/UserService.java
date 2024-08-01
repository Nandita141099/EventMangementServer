package com.elysiana.service;

import java.util.List;

import com.elysiana.entities.User;
import com.elysiana.payloads.UserDto;

public interface  UserService {
	User createUser(User user);

	UserDto createUser(UserDto user);

	UserDto updateUser(UserDto userDto, Integer id1);
	UserDto getUserById(Integer id);

	List<UserDto>getAllUser(); 
	void deleteUser(Integer id);
	

}
