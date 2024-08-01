package com.elysiana.repository;

import org.springframework.data.repository.CrudRepository;

import com.elysiana.entities.User;

public interface  UserRepository extends CrudRepository<User,Integer> {
	

}
