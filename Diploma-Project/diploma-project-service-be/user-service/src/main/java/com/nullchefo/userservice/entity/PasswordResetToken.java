package com.nullchefo.userservice.entity;

import java.util.Calendar;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "password-reset-token")
public class PasswordResetToken {

	// TODO create cron-job to clean older password reset request

	//Expiration time 10 minutes
	private static  final int EXPIRATION_TIME = 10;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String token;

	private Date expirationTime;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id",
				nullable = false
				,foreignKey = @ForeignKey(name = "FK_USER_PASSWORD_TOKEN")
	)
	private User user;

	public PasswordResetToken(User user, String token) {
		super();
		this.token = token;
		this.user = user;
		this.expirationTime = calculateExpirationDate(EXPIRATION_TIME);
	}

	public PasswordResetToken(String token) {
		super();
		this.token = token;
		this.expirationTime = calculateExpirationDate(EXPIRATION_TIME);
	}

	private Date calculateExpirationDate(int expirationTime) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(new Date().getTime());
		calendar.add(Calendar.MINUTE, expirationTime);
		return new Date(calendar.getTime().getTime());
	}
}

