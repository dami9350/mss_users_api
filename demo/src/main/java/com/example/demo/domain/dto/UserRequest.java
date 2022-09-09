package com.example.demo.domain.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
	@NotNull(message = "아이디는 필수 입력 값입니다.")
	@Pattern(regexp = "^[a-z0-9]{5,20}$", message = "아이디는 영어 소문자와 숫자만 사용하여 5~20자리여야 합니다.")
	private String id;
	
	@NotNull(message = "비밀번호는 필수 입력 값입니다.")
	@Pattern(regexp = "^(?=.*[a-zA-Z0-9])(?=.*[a-zA-Z!@#$%^&*])(?=.*[0-9!@#$%^&*]).{8,20}$", message = "비밀번호는 8~20자리수여야 합니다. 영문 대소문자, 숫자, 특수문자를 2개 이상 포함해야 합니다.")
	private String password;
	
	@NotNull(message = "이메일은 필수 입력 값입니다.")
	@Email(message = "이메일 형식에 맞지 않습니다.")
	private String email;
	
	@NotNull(message = "핸드폰번호는 필수 입력 값입니다.")
	@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다. xxx-xxxx-xxxx")
	private String phoneNumber;
}
