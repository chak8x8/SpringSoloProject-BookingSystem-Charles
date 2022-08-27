package com.fdmgroup.com.SpringSoloProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.data.jpa.repository.JpaRepository;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import com.fdmgroup.com.SpringSoloProject.controller.AppController;
import com.fdmgroup.com.SpringSoloProject.controller.ReviewController;
import com.fdmgroup.com.SpringSoloProject.dal.MemberRepository;
import com.fdmgroup.com.SpringSoloProject.dal.RecordRepository;
import com.fdmgroup.com.SpringSoloProject.dal.ReviewRepository;
import com.fdmgroup.com.SpringSoloProject.model.Member;
import com.fdmgroup.com.SpringSoloProject.model.Record;
import com.fdmgroup.com.SpringSoloProject.model.Review;
import com.fdmgroup.com.SpringSoloProject.service.MemberService;
import com.fdmgroup.com.SpringSoloProject.service.RecordService;
import com.fdmgroup.com.SpringSoloProject.service.ReviewService;

@ExtendWith(MockitoExtension.class)
public class ReviewControllerTest {

	@Mock
	private Model modelMock;
	
	
	private Member member;
	private Review review;
	
	private Record record;

//	@Autowired
//	private ReviewRepository reviewRepository;
//	
//	@Autowired
//	private RecordRepository recordRepository;

	@Mock
	private ReviewService reviewService;
	
	@Mock
	private RecordService recordService;

	
	private ReviewController reviewController;

	@BeforeEach
	public void setup() {
		
		member = new Member("Peter", "Smith", "peter@fdm.com", new BCryptPasswordEncoder().encode("123456"));
		Date date1 = new Date();
		Date date2 = new Date();
		record = new Record(member, date1, date2, false);
		review = new Review(record,"abc");
		reviewController = new ReviewController(recordService, reviewService);
		
	}

	@Test
	void test_editReview_returnsCorrectView() {
		// Arrange
		String expected = "review.html";
		// Action
		String actual = reviewController.editReview(1L, modelMock);
		// Assert
		assertEquals(expected, actual);
	}

	@Test
	void test_saveReview_returnsCorrectView() {
		// Arrange
		String expected = "review_success.html";
		// Action
		String actual = reviewController.saveReview(review);
		// Assert
		assertEquals(expected, actual);
		

	}

	@Test
	void test_getReviews_returnsCorrectView() {
		// Arrange
		String expected = "reviews.html";
		// Action
		String actual = reviewController.getReviews(modelMock);
		// Assert
		assertEquals(expected, actual);
	}


}
