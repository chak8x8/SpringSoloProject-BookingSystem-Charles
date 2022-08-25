//package com.fdmgroup.com.SpringSoloProject.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.fdmgroup.com.SpringSoloProject.model.Member;
//import com.fdmgroup.com.SpringSoloProject.model.Room;
//import com.fdmgroup.com.SpringSoloProject.service.MemberService;
//import com.fdmgroup.com.SpringSoloProject.service.RoomService;
//
//@Controller
//public class RoomController {
//	
//	private RoomService roomService;
//	
//	
//	public RoomController(RoomService roomService) {
//		super();
//		this.roomService = roomService;
//	}
//
////	@GetMapping("/movie/{id}")
////	public String getMembersPageById(@PathVariable(name="id") Long id, Model model) {
////		Member foundMember = this.memberService.findById(id);
////		System.out.println(foundMovie);
////		model.addAttribute("foundMovie",foundMovie);
////		return "Movie";
////	}
//	
//	
//	@GetMapping("/editRoom")
//	public String showUpdateForm(Model model, @RequestParam Long id) {
//		Room room = roomService.findById(id);
//		model.addAttribute("room", room);
//		return "editRoom";
//	}
//}
