package com.fdmgroup.com.SpringSoloProject.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.fdmgroup.com.SpringSoloProject.model.Member;
import com.fdmgroup.com.SpringSoloProject.model.Review;
import com.fdmgroup.com.SpringSoloProject.model.Record;
import com.fdmgroup.com.SpringSoloProject.service.MemberService;
import com.fdmgroup.com.SpringSoloProject.service.RecordService;
import com.fdmgroup.com.SpringSoloProject.service.ReviewService;

@Controller
public class ReviewController {
	
	private ReviewService reviewService;
	
	private RecordService recordService;
	
	
	public ReviewController(RecordService recordService, ReviewService reviewService) {
		super();
		this.recordService = recordService;
		this.reviewService = reviewService;
	}

//	@GetMapping("/movie/{id}")
//	public String getMembersPageById(@PathVariable(name="id") Long id, Model model) {
//		Member foundMember = this.memberService.findById(id);
//		System.out.println(foundMovie);
//		model.addAttribute("foundMovie",foundMovie);
//		return "Movie";
//	}

	
	@GetMapping("/review/{id}")
	public String editReview(@PathVariable(name="id") Long id, Model model) {
		Review review = new Review();
		Record record = this.recordService.findById(id);
//		System.out.println(record.toString());
		review.setRecord(record);
		model.addAttribute("review", review);
		return "review.html";
	}
	
	@PostMapping("/saveReview")
	public String saveMovie(@ModelAttribute Review review) {
		System.out.println(review.toString());
		review.setCommentDate(new Date());
		this.reviewService.save(review);
		Record record = review.getRecord();
		record.setReviewed(true);
		this.recordService.save(record);
		return "member_index.html";
	}
	
	@GetMapping("/reviews")
	public String getReviews(Model model) {
		List<Review> reviews = this.reviewService.findAll();
		model.addAttribute("reviews", reviews);
		return "reviews.html";
	}
	
}
