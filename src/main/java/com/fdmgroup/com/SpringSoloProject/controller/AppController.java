package com.fdmgroup.com.SpringSoloProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fdmgroup.com.SpringSoloProject.dal.MemberRepository;
import com.fdmgroup.com.SpringSoloProject.model.Member;

@Controller
public class AppController {
	
	@Autowired
	private MemberRepository memberReposity;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index.html";
		
	}
	
	@GetMapping("/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("member", new Member());
		return "signup_form.html";
		
	}
	
	@PostMapping("/process_register")
	public String processRegistration(Member member) {
		String newPassword = new BCryptPasswordEncoder().encode(member.getPassword());
		member.setPassword(newPassword);
		memberReposity.save(member);
		return "register_success.html";
	}
	
	@PostMapping("/process_edit")
	public String processEdit(Member member) {
		String newPassword = new BCryptPasswordEncoder().encode(member.getPassword());
		member.setPassword(newPassword);
		memberReposity.save(member);
		return "edit_success.html";
	}
	
	@GetMapping("/list_members")
	public String viewMembersList() {
		return "members.html";
	}
	

}
