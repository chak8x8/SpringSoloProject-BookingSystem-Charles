package com.fdmgroup.com.SpringSoloProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fdmgroup.com.SpringSoloProject.dal.MemberRepository;
import com.fdmgroup.com.SpringSoloProject.model.Member;
import com.fdmgroup.com.SpringSoloProject.service.MemberService;

/**
 * 
 * @author chak8x8
 *
 * This class is to return the view to be rendered as a response.
 */
@Controller
public class AppController {

	private MemberService memberService;

	@Autowired
	public AppController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}

	public AppController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * It is a method that will redirect to index page.
	 * 
	 * @return
	 */
	@GetMapping("")
	public String viewHomePage() {
		return "index.html";

	}

	/**
	 * It is a method that the address is register and will redirect to signup_form
	 * page.
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("member", new Member());
		return "signup_form.html";

	}

	/**
	 * It is a method that the address is process_register and the memberService will call the save method and redirect to register_success page.
	 * 
	 * @param member
	 * @return
	 */
	@PostMapping("/process_register")
	public String processRegistration(Member member) {
		String newPassword = new BCryptPasswordEncoder().encode(member.getPassword());
		member.setPassword(newPassword);
		this.memberService.save(member);
		return "register_success.html";
	}

	/**
	 * 
	 * @param member
	 * @return
	 */
	@PostMapping("/process_edit")
	public String processEdit(Member member) {
		String newPassword = new BCryptPasswordEncoder().encode(member.getPassword());
		member.setPassword(newPassword);
		this.memberService.save(member);
		return "edit_success.html";
	}

	/**
	 *It is a method that the address is list_members and will redirect to members page. 
	 * @return
	 */
	@GetMapping("/list_members")
	public String viewMembersList() {
		return "members.html";
	}

}
