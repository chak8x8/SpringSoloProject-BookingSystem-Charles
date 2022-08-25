package com.fdmgroup.com.SpringSoloProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.fdmgroup.com.SpringSoloProject.dal.MemberRepository;
import com.fdmgroup.com.SpringSoloProject.model.CustomerMemberDetails;
import com.fdmgroup.com.SpringSoloProject.model.Member;

public class CustomMemberDetailsService implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Member member = memberRepository.findByEmail(email);
		if(member == null) {
			throw new UsernameNotFoundException("Member not found");
		}
		System.out.println("Login works");
		return new CustomerMemberDetails(member);
	}
	
	
}
