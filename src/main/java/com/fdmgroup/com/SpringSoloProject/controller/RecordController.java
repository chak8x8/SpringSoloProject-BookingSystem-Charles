package com.fdmgroup.com.SpringSoloProject.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fdmgroup.com.SpringSoloProject.model.Member;
import com.fdmgroup.com.SpringSoloProject.model.Record;
import com.fdmgroup.com.SpringSoloProject.service.MemberService;
import com.fdmgroup.com.SpringSoloProject.service.RecordService;

/**
 * This class is to return the view to be rendered as a response.
 * @author chak8x8
 *
 */
@Controller
public class RecordController {
	
	private MemberService memberService;
	private RecordService recordService;
	
	
	public RecordController(MemberService memberService, RecordService recordService) {
		super();
		this.memberService = memberService;
		this.recordService = recordService;
	}
	

	/**
	 *  It is a method that the address is myRecords and it will find the current user date and load his records for the next page and redirect to myRecords page.
	 * @param model
	 * @param auth
	 * @return
	 */
	@GetMapping("/myRecords")
	public String viewMyRecords(Model model, Authentication auth) {
		Member member = memberService.findByEmail(auth.getName());
		System.out.println("My ID: " + member.getMemberId());
		List<Record> listRecords = recordService.findByMemberId(member.getMemberId());
		System.out.println("My List: " + listRecords);
		model.addAttribute("listRecords", listRecords);
		return "myRecords.html";
		
	}
}
