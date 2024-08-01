package com.elysiana.service;

import java.util.List;

import com.elysiana.payloads.SignupRequest;
import com.elysiana.payloads.UserDto;

public interface UserService {

	void signup(SignupRequest signupRequest) throws Exception;
	void createUser(UserDto userDto);
	void updateUserById(UserDto userDto, Integer userId);
	List<UserDto> getAllUsers();
	UserDto getUserById(Integer userId);
	void deleteUser(Integer userId);

}
