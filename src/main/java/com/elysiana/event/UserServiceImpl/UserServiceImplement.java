package com.elysiana.event.UserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.elysiana.event.UserRepository.UserRepository;
import com.elysiana.event.UserService.UserService;
import com.elysiana.event.Userdto.User;
import com.elysiana.event.Userdto.UserDto;

public class UserServiceImplement implements UserService {
	@Autowired
	private UserRepository  repo;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user=this.dtoToUser(userDto);
		User savedUser=this.repo.save(user);
		
		return this.userToDto(savedUser);
	}
	@Override
	public UserDto updateUser(UserDto user, Integer id) {
		
		return null;
	}

	@Override
	public UserDto getUserById(Integer id) {
		
		return null;
	}

	@Override
	public List<UserDto> getAllUser() {
		
		return null;
	}

	@Override
	public void deleteUser(Integer id) {
	}
	public  User dtoToUser(UserDto userDto) {
		User user=new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setContact(userDto.getContact());
		user.setPassword(userDto.getPassword());
		return user;
		
	}
	public UserDto userToDto(User user) {
		UserDto userDto=new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setContact(user.getContact());
		userDto.setPassword(user.getPassword());
		return userDto;
		
		
		
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
