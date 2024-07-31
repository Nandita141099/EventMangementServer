package com.elysiana.event.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elysiana.event.user.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

}
