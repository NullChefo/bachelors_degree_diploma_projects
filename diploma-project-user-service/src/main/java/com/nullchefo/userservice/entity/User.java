package com.nullchefo.userservice.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(length = 60, unique = true, nullable = false)
	private String username;
	@Column(name = "password", length = 1000, columnDefinition = "text")
	private String password;
	@Column(name = "granted_authorities", length = 1000, columnDefinition = "text")
	private String grantedAuthorities;
	private LocalDateTime updatedAt;
	private LocalDateTime createdAt = LocalDateTime.now();
	private boolean enabled = false; // email verified
	private boolean credentialsNonExpired = true;
	private boolean accountLocked = false;
	private boolean accountExpired = false;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthday;
}

