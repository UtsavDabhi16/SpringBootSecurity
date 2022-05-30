package com.inexture.springBootSecurity.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inexture.springBootSecurity.Repo.AddressDaoInterface;
import com.inexture.springBootSecurity.Repo.AdminDaoInterface;
import com.inexture.springBootSecurity.Repo.UserDaoInterface;



@Service
public class CustomUserService implements UserDetailsService {

	@Autowired
	UserDaoInterface userDaoInterface;

	@Autowired
	AddressDaoInterface addressDaoInterface;

	@Autowired
	AdminDaoInterface adminDaoInterface;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserBean ubean = userDaoInterface.getUserEmail(email);
		return new CustomUserDetails(ubean);
	}

}
