package com.inexture.springBootSecurity.Model;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;

	private UserBean user;

	public CustomUserDetails(UserBean user) {
		System.out.println("Userbean is :" + user);
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		HashSet<SimpleGrantedAuthority> set = new HashSet<>();
		System.out.println("Role is :" + this.user.getRole());
		set.add(new SimpleGrantedAuthority(this.user.getRole()));
		return set;
	}

	@Override
	public String getPassword() {
		System.out.println("User password" + this.user.getPassword());
		
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		System.out.println("User email is:"+this.user.getEmail());
		return this.user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
