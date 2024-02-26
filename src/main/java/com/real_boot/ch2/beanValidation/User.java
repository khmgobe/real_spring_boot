package com.real_boot.ch2.beanValidation;

import lombok.Getter;

@Getter
public class User {

	private String userName;

	@Password
	private String password;

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}


	@Override
	public String toString() {
		return "User{" +
				"userName='" +
				userName + '\'' +
				", password='" +
				password + '\'' +
				'}';
	}
}
