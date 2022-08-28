package com.fdmgroup.com.SpringSoloProject.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fdmgroup.com.SpringSoloProject.service.CustomMemberDetailsService;

/**
 * This is a class that is a configuration for web security.
 * @author chak8x8
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	/**
	 * It is used for retrieving a username, password, and other attributes for authenticating with a username and password.
	 * @return
	 */
	@Bean
	public UserDetailsService memberDetailsService() {
		return new CustomMemberDetailsService();
	}

	/**
	 * This method is to encode password.
	 * @return
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

	/**
	 * This method leverages a UserDetailsService in order to lookup the username and password.
	 * @return
	 */
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(memberDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	/**
	 * This method is to authenticate and authorize users.
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	/**
	 * This a method that if the input matches the data, user can go to next page.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().antMatchers("/list_members").authenticated().anyRequest().permitAll().and()
				.formLogin().usernameParameter("email").defaultSuccessUrl("/member_index").permitAll().and().logout().logoutSuccessUrl("/")
				.permitAll();
		
	}
	
	

}
