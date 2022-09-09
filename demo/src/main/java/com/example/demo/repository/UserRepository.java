package com.example.demo.repository;


import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.example.demo.domain.entity.User;

public interface UserRepository extends Repository<User, Long> {

	Optional<User> findByNo(Long no);
	User save(User user);
	Optional<User> findById(String id);
	
}
