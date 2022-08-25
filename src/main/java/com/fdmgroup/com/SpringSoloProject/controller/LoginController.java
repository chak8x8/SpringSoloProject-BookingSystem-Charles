package com.fdmgroup.com.SpringSoloProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fdmgroup.com.SpringSoloProject.service.MemberService;

@Controller
public class LoginController {
	private MemberService memberService;
	
	@Autowired
	public LoginController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}
	
	@GetMapping("login")
	public String getMoviesPage(Model model) {
//		List<Member> members = this.memberService.findAll();
//		model.addAttribute("movies", movies);
		return null;
	}
	
}
