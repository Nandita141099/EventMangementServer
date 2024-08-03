package com.elysiana.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.elysiana.entities.User;
import com.elysiana.exceptions.ResourceNotFoundException;
import com.elysiana.payloads.SignupRequest;
import com.elysiana.payloads.UserDto;
import com.elysiana.repository.UserRepository;
import com.elysiana.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public void signup(SignupRequest signupRequest) throws Exception {
		if (userRepo.existsByEmail(signupRequest.getEmail())) {
			throw new Exception("Email is already taken");
		}

		User user = new User();
		user.setName(signupRequest.getName());
		user.setEmail(signupRequest.getEmail());
		user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
		user.setContact(signupRequest.getContact());
		user.setRole(signupRequest.getRole());

		userRepo.save(user);
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		return userToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> listOfUsers = userRepo.findAll();
		List<UserDto> UserDtos = listOfUsers.stream().map(user -> userToUserDto(user)).collect(Collectors.toList());
		return UserDtos;
	}

	@Override
	public void createUser(UserDto userDto) {
		User user = userDtoToUser(userDto);
		userRepo.save(user);

	}

	@Override
	public void updateUserById(UserDto userDto, Integer userId) {
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		user.setUserId(userDto.getUserId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setContact(userDto.getContact());
		user.setRole(userDto.getRole());
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		userRepo.delete(user);
	}

	private User userDtoToUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		return user;
	}

	public UserDto userToUserDto(User user) {
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return userDto;
	}
}
