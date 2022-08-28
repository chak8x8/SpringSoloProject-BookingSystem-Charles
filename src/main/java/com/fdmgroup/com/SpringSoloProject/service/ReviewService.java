package com.fdmgroup.com.SpringSoloProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.com.SpringSoloProject.dal.ReviewRepository;
import com.fdmgroup.com.SpringSoloProject.model.Review;

@Service
public class ReviewService {
	private ReviewRepository reviewRepo;

	@Autowired
		public ReviewService(ReviewRepository reviewRepo) {
			super();
			this.reviewRepo = reviewRepo;
		}

	/**
	 * It is a method to find a review with specific review id.
	 * @param id
	 * @return
	 */
	public Review findById(Long id) {
		try {
			return (this.reviewRepo.findById(id))
					.orElseThrow(() -> new Exception("Review with id: " + id + " cannot be found"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * It is a method to find all reviews.
	 * @return
	 */
	public List<Review> findAll() {
		return this.reviewRepo.findAll();
	}
	
	/**
	 * It is a method to save the new review in the database, or update the existing review.
	 * @param review
	 * @return
	 */
	public Review save(Review review) {
		return reviewRepo.save(review);
		
	}
	
	
}
