package com.sdacademy.rest.webservices.restfulwebservices.jwt.resource;

import java.io.Serializable;

public class JwtTokenRequest implements Serializable {

	private static final long serialVersionUID = -5616176897013108345L;

	private String username;
	private String password;

//	{
//    	"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJTREEiLCJleHAiOjE2NDI4NzIyNDEsImlhdCI6MTY0MjI2NzQ0MX0.0ZEnlr7tzcEMSE30dV8yrHRKGtK8_Hb8wWoiTWATD_5-7o_oX8-9gOCEGj_Lr_CxaA3EDNgD9QWYTJEj2Eyraw"
//    }

	public JwtTokenRequest() {
		super();
	}

	public JwtTokenRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
