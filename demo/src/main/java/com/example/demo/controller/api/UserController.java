package com.example.demo.controller.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.dto.UserRequest;
import com.example.demo.domain.entity.User;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(path = "/api/users")
@RestController
public class UserController {
	
	private final UserService userService;
	
	@PostMapping("")
	public ResponseEntity<?> insert(@RequestBody @Valid final UserRequest user) throws Exception {
		return ResponseEntity.ok(userService.insert(user));
	}

	@GetMapping("/{no}")
	public Map<String, Object> select(@PathVariable("no") long no) {
		Map<String, Object> response = new HashMap<>();

		Optional<User> oUser = userService.select(no);
		if(oUser.isPresent()) {
			response.put("result", "SUCCESS");
			response.put("user", oUser.get());
		} else {
			response.put("result", "FAIL");
			response.put("reason", "일치하는 회원 정보가 없습니다. 사용자 id를 확인해주세요.");
		}

		return response;
	}
}
