package com.fdmgroup.com.SpringSoloProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fdmgroup.com.SpringSoloProject.dal.ReviewRepository;
import com.fdmgroup.com.SpringSoloProject.model.Review;

import com.fdmgroup.com.SpringSoloProject.service.ReviewService;

@SpringBootTest
class ReviewServiceTest {

	private ReviewService reviewService;

	@MockBean
	private ReviewRepository reviewRepo;

	@Mock
	private Review review;

	@BeforeEach
	public void setup() {
		review = new Review();
		reviewService = new ReviewService(reviewRepo);
		
	}

	@Test
	void test_review_isFoundByID() {
		// Arrange
		when(reviewRepo.findById(review.getReviewId())).thenReturn(Optional.of(review));

		// Action
		Review foundReview = reviewService.findById(review.getReviewId());

		// Assert
		assertEquals(review.getReviewId(), foundReview.getReviewId());
		verify(reviewRepo, times(1)).findById(review.getReviewId());
	}


	@Test
	void test_review_foundAll() {
		// Arrange

		// Action
		reviewService.findAll();

		// Assert
		verify(reviewRepo, times(1)).findAll();
	}

	@Test
	void test_review_isSaved() {
		// Arrange

		// Action
		reviewService.save(review);

		// Assert
		verify(reviewRepo, times(1)).save(review);

	}

}
