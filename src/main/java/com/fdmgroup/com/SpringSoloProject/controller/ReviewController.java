package com.fdmgroup.com.SpringSoloProject.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.fdmgroup.com.SpringSoloProject.model.Review;
import com.fdmgroup.com.SpringSoloProject.model.Record;
import com.fdmgroup.com.SpringSoloProject.service.RecordService;
import com.fdmgroup.com.SpringSoloProject.service.ReviewService;

/**
 * This class is to return the view to be rendered as a response.
 * @author chak8x8
 *
 */
@Controller
public class ReviewController {
	
	private ReviewService reviewService;
	
	private RecordService recordService;
	
	
	public ReviewController(RecordService recordService, ReviewService reviewService) {
		super();
		this.recordService = recordService;
		this.reviewService = reviewService;
	}

	/**
	 * It is a method that the address is review/{id} and it will find a specific record and will be loaded for user to leave review on next page and then it will redirect to review page.
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/review/{id}")
	public String leaveReview(@PathVariable(name="id") Long id, Model model) {
		Review review = new Review();
		Record record = this.recordService.findById(id);
		review.setRecord(record);
		model.addAttribute("review", review);
		return "review.html";
	}
	
	/**
	 * It is a method that the address is saveReview and reviewService will call the save method and record will know that this record got a review and will not allow user to add new review and then it will redirect to review_success page.
	 * @param review
	 * @return
	 */
	@PostMapping("/saveReview")
	public String saveReview(@ModelAttribute Review review) {
		review.setCommentDate(new Date());
		this.reviewService.save(review);
		Record record = review.getRecord();
		record.setReviewed(true);
		this.recordService.save(record);
		return "review_success.html";
	}
	
	/**
	 * It is a method that the address is reviews and it loads all reviews for next page to display and it will redirect to reviews page.
	 * @param model
	 * @return
	 */
	@GetMapping("/reviews")
	public String getReviews(Model model) {
		List<Review> reviews = this.reviewService.findAll();
		model.addAttribute("reviews", reviews);
		return "reviews.html";
	}
	
}
