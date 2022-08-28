package com.fdmgroup.com.SpringSoloProject.controller;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.com.SpringSoloProject.model.Member;
import com.fdmgroup.com.SpringSoloProject.model.Record;
import com.fdmgroup.com.SpringSoloProject.service.MemberService;
import com.fdmgroup.com.SpringSoloProject.service.RecordService;

/**
 * This class is to return the view to be rendered as a response.
 * 
 * @author chak8x8
 *
 */
@Controller
public class MemberController {
	
	private MemberService memberService;
	
	private RecordService recordService; 
	
	
	public MemberController(MemberService memberService, RecordService recordService) {
		super();
		this.memberService = memberService;
		this.recordService = recordService;
	}

	/**
	 * It is a method that the address is index and it will direct to index page.
	 * @param member
	 * @return
	 */
	@GetMapping("/index")
	public String getPreLoginPage(Member member) {
		return "index.html";
	}
	
	/**
	 * It is a method that the address is member_index and it will direct to member_index page.
	 * @param member
	 * @return
	 */
	@GetMapping("/member_index")
	public String getMemberIndex(Member member) {
		return "member_index.html";
	}
	
	/**
	 * It is a method that the address is reservation_1 and it will direct to reservation_1 page.
	 * @param member
	 * @return
	 */
	@GetMapping("/reservation_1")
	public String getReservation1(Member member) {
		return "reservation_1.html";
	}
	
	/**
	 * It is a method that the address is reservation_2 and will direct to reservation_2 page.
	 * @param member
	 * @return
	 */
	@GetMapping("/reservation_2")
	public String getReservation2(Member member) {
		return "reservation_2.html";
	}

	/**
	 * It is a method that the address is editMember and the memberService will call the save method to transfer data to MySQL and redirect to editMember page.
	 * @param model
	 * @param auth
	 * @return
	 */
	@GetMapping("/editMember")
	public String editMemberForm(Model model, Authentication auth) {
		Member member = this.memberService.findByEmail(auth.getName());
		model.addAttribute("member", member);
		String newPassword = new BCryptPasswordEncoder().encode(member.getPassword());
		member.setPassword(newPassword);
		this.memberService.save(member);
		return "editMember.html";
	}
	
	/**
	 * It is a method that the address is checkOut and it will transfer startDate, endDate, duration and totalPrice to next page and redirect to reservation_1 page.
	 * @param startDate
	 * @param endDate
	 * @param model
	 * @return
	 */
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
	
	/**
	 * It is a method that the address is checkOut and it will transfer member, startDate, endDate, duration and totalPrice to next page, and then it will generate a new record and recordService will call save method and transfer it to MySQL and then redirect to reservation_2 page.
	 * @param startDate
	 * @param endDate
	 * @param model
	 * @param auth
	 * @return
	 */
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
		this.recordService.save(record);	
		return "reservation_2.html";		
	}
	
	
}
