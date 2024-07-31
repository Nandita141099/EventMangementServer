package com.elysiana.event.UserService;

import java.util.List;

import com.elysiana.event.Userdto.User;
import com.elysiana.event.Userdto.UserDto;

public interface  UserService {
	User createUser(User user);

	UserDto createUser(UserDto user);

	UserDto updateUser(UserDto userDto, Integer id1);
	UserDto getUserById(Integer id);

	List<UserDto>getAllUser(); 
	void deleteUser(Integer id);
	

}
