package com.fdmgroup.com.SpringSoloProject.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.com.SpringSoloProject.model.Member;
import com.fdmgroup.com.SpringSoloProject.model.Record;
import com.fdmgroup.com.SpringSoloProject.service.MemberService;
import com.fdmgroup.com.SpringSoloProject.service.RecordService;


@Controller
public class RecordController {
	
	private MemberService memberService;
	private RecordService recordService;
	
	
	public RecordController(MemberService memberService, RecordService recordService) {
		super();
		this.memberService = memberService;
		this.recordService = recordService;
	}
	
	
	@GetMapping("/editRecord")
	public String showUpdateForm(Model model, @RequestParam Long id) {
		Record record = recordService.findById(id);
		model.addAttribute("record", record);
		return "editRecord.html";
	}
	
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
