package com.fdmgroup.com.SpringSoloProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fdmgroup.com.SpringSoloProject.dal.MemberRepository;
import com.fdmgroup.com.SpringSoloProject.model.Member;
import com.fdmgroup.com.SpringSoloProject.model.Record;

@Service
public class MemberService {
	private MemberRepository memberRepo;

	@Autowired
		public MemberService(MemberRepository memberRepo) {
			super();
			this.memberRepo = memberRepo;
		}

	public Member findById(Long id) {
		try {
			return (this.memberRepo.findById(id))
					.orElseThrow(() -> new Exception("Member with id: " + id + " cannot be found"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Member findByEmail(String email) {
		Member member = memberRepo.findByEmail(email);
		if(member == null) {
			throw new UsernameNotFoundException("Member not found");
		}
		return member;
	}

	/**
	 * It is a method to find all members
	 * @return
	 */
	public List<Member> findAll() {
		return this.memberRepo.findAll();
	}
	
	public Member save(Member member) {
		return memberRepo.save(member);
		
	}
	
	
}
