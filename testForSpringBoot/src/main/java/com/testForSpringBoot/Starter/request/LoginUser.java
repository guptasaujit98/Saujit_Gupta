package com.testForSpringBoot.Starter.request;

import lombok.Data;

@Data
public class LoginUser {

	public String email;
	public String pwd;

	public LoginUser() {

	}

}
