package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.dto.UserRequest;
import com.example.demo.domain.entity.User;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;

	public Optional<User> select(Long no) {
		Optional<User> user =  userRepository.findByNo(no);
		
		return user;
	}

	@Transactional
	public boolean insert(final UserRequest u) throws Exception {
		
		if(userRepository.findById(u.getId()).isPresent()) {
			return false;
		}
		/*
		userRepository.save(User.builder()
				.id(encrypt.encryptAES256(u.getId()))
				.password(u.getPassword())
				.email(encrypt.encryptAES256(u.getEmail()))
				.phoneNumber(encrypt.encryptAES256(u.getPhoneNumber()))
				.build());
		*/
		userRepository.save(User.builder()
				.id(u.getId())
				.password(passwordEncoder.encode(u.getPassword()))
				.email(u.getEmail())
				.phoneNumber(u.getPhoneNumber())
				.build());
		return true;
	}
	
}
