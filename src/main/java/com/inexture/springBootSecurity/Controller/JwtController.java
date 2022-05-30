package com.inexture.springBootSecurity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inexture.springBootSecurity.Helper.JwtUtil;
import com.inexture.springBootSecurity.Model.UserBean;
import com.inexture.springBootSecurity.Model.jwtResponse;
import com.inexture.springBootSecurity.Service.CustomUserService;

@RestController
public class JwtController {

	@Autowired
	CustomUserService customUserService;

	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	AuthenticationManager authenticationManager;

	@PostMapping("/token")
	public ResponseEntity<?> genrateToken(@RequestBody UserBean user) {
		System.out.println("UserBean is :" + user);
		try {
			this.authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		UserDetails userDetails = this.customUserService.loadUserByUsername(user.getEmail());
		String token = this.jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new jwtResponse(token));
	}
}
