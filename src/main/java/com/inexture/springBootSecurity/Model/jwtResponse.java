package com.inexture.springBootSecurity.Model;

public class jwtResponse {
	String token;



	public void setToken(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}
	

	public jwtResponse() {

	}

	public jwtResponse(String token) {

		this.token = token;
	}
}
