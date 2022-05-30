package com.inexture.springBootSecurity;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.inexture.springBootSecurity.Model.CustomUserService;



@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter  {
    
	@Autowired
	CustomUserService customUserService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeHttpRequests()
		.antMatchers("/","/views/**").permitAll()
		.antMatchers("/").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/")
		.usernameParameter("uemail")
		.passwordParameter("upassword")
		.loginProcessingUrl("/register")
		.defaultSuccessUrl("admin");
			
	}
	 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserService).passwordEncoder(passwordEncoder());
	auth.inMemoryAuthentication().withUser("admin").password(this.passwordEncoder().encode("admin")).roles("ADMIN");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder();
	}

}
