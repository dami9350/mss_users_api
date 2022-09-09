package com.example.demo.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.example.demo.util.Aes256Converter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@DynamicInsert @DynamicUpdate
@Getter
@Entity
@Table(name = "users", indexes = {@Index(name = "PK_USERS_NO", columnList = "no")})
public class User implements Serializable {
	
	private static final long serialVersionUID = -4253749884585192245L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false, columnDefinition = "INT UNSIGNED")
	private Long no;
	
	@Column(nullable = false, length = 24, unique = true)
	@Convert(converter = Aes256Converter.class)
	@Setter 
	private String id;
	
	@JsonIgnore
	@Column(nullable = false, length = 150)
	@Setter 
	private String password;
	
	@Column(nullable = false, length = 24)
	@Convert(converter = Aes256Converter.class)
	@Setter 
	private String email;
	
	@Column(nullable = false, length = 24)
	@Convert(converter = Aes256Converter.class)
	@Setter 
	private String phoneNumber;
	
	@Builder
	public User(String id, String password, String email, String phoneNumber) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
}