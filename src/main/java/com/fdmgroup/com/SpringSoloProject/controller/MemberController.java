package com.fdmgroup.com.SpringSoloProject.controller;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.com.SpringSoloProject.dal.RecordRepository;
import com.fdmgroup.com.SpringSoloProject.model.Member;
import com.fdmgroup.com.SpringSoloProject.model.Review;
import com.fdmgroup.com.SpringSoloProject.model.Record;
import com.fdmgroup.com.SpringSoloProject.service.MemberService;
import com.fdmgroup.com.SpringSoloProject.service.RecordService;

@Controller
public class MemberController {
	
	private MemberService memberService;
	
	private RecordService recordService; 
	
	
	public MemberController(MemberService memberService, RecordService recordService) {
		super();
		this.memberService = memberService;
		this.recordService = recordService;
	}

	
	@GetMapping("/index")
	public String getPreLoginPage(Member member) {
		return "index.html";
	}
	
	@GetMapping("/member_index")
	public String getMemberIndex(Member member) {
		return "member_index.html";
	}
	
	@GetMapping("/reservation_1")
	public String getReservation1(Member member) {
		return "reservation_1.html";
	}
	
	@GetMapping("/reservation_2")
	public String getReservation2(Member member) {
		return "reservation_2.html";
	}
	
//	@GetMapping("/myRecords")
//	public String getMyRecords(Member member) {
//		return "myRecords.html";
//	}
	
	@GetMapping("/editMember")
	public String showUpdateForm(Model model, Authentication auth) {
		Member member = memberService.findByEmail(auth.getName());
		model.addAttribute("member", member);
		String newPassword = new BCryptPasswordEncoder().encode(member.getPassword());
		member.setPassword(newPassword);
		memberService.save(member);
		return "editMember.html";
	}
	
	@GetMapping("/checkOut")
	public String checkOut(@RequestParam Date startDate, @RequestParam Date endDate, Model model) {
		long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());     
		long duration = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		float price = 100;
		float totalPrice = price * duration;
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("duration", duration);
		model.addAttribute("totalPrice", totalPrice);
		return "reservation_1.html";		
	}
	
	
	@GetMapping("/confirm")
	public String confirm(@RequestParam Date startDate, @RequestParam Date endDate, Model model, Authentication auth) {
		long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());     
		long duration = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		float price = 100;
		float totalPrice = price * duration;
		Member member = memberService.findByEmail(auth.getName());
		model.addAttribute("member", member);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("duration", duration);
		model.addAttribute("totalPrice", totalPrice);
		Record record = new Record(member, startDate, endDate, false);
		model.addAttribute("record", record); 
		recordService.save(record);	
		return "reservation_2.html";		
	}
	
	
}
