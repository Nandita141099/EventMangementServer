package com.elysiana.event.UserRepository;

import org.springframework.data.repository.CrudRepository;

import com.elysiana.event.Userdto.User;

public interface  UserRepository extends CrudRepository<User,Integer> {
	

}
