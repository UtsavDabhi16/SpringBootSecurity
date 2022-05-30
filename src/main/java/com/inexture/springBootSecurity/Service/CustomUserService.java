package com.inexture.springBootSecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.inexture.springBootSecurity.Model.CustomUserDetails;
import com.inexture.springBootSecurity.Model.UserBean;
import com.inexture.springBootSecurity.Repo.AddressDaoInterface;
import com.inexture.springBootSecurity.Repo.AdminDaoInterface;
import com.inexture.springBootSecurity.Repo.UserDaoInterface;

@Component
public class CustomUserService implements UserDetailsService {

	@Autowired
	UserDaoInterface userDaoInterface;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserBean ubean = userDaoInterface.getUserEmail(username);
	
		return new CustomUserDetails(ubean);

	}

}
