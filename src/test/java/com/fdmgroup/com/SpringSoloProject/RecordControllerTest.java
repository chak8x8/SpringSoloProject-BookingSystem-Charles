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
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import com.fdmgroup.com.SpringSoloProject.controller.AppController;
import com.fdmgroup.com.SpringSoloProject.controller.RecordController;
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
public class RecordControllerTest {
	@Mock
	Authentication authentication;
	
	@Mock
	private RecordService recordService;
	
	@Mock
	private MemberService memberServiceMock;

	@Mock
	private Model modelMock;
	
	private RecordController recordController;

	@BeforeEach
	public void setup() {
		recordController = new RecordController(memberServiceMock, recordService);

	}
	
	@Test
	void test_viewMyRrcords() {
		// Arrange
		String expected = "myRecords.html";
		
		// Action
		String actual = recordController.viewMyRecords(modelMock, authentication);
		
		// Assert
		assertEquals(expected, actual);
	}


}
