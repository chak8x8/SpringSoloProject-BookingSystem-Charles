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
	 * It is a method to find all members
	 * @return
	 */
	public List<Review> findAll() {
		return this.reviewRepo.findAll();
	}
	
	public Review save(Review review) {
		return reviewRepo.save(review);
		
	}
	
	
}
