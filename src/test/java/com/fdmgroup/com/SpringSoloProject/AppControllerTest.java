package com.fdmgroup.com.SpringSoloProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import com.fdmgroup.com.SpringSoloProject.controller.AppController;
import com.fdmgroup.com.SpringSoloProject.dal.MemberRepository;
import com.fdmgroup.com.SpringSoloProject.model.Member;
import com.fdmgroup.com.SpringSoloProject.service.MemberService;

@ExtendWith(MockitoExtension.class)
public class AppControllerTest {

	@Mock
	private Model modelMock;

	private Member member;

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private MemberService memberService;

	private AppController appController;

	@BeforeEach
	public void setup() {
		appController = new AppController();
		memberService = new MemberService(memberRepository);
		member = new Member("Peter", "Smith", "peter@fdm.com", new BCryptPasswordEncoder().encode("123456"));
	}

	@Test
	void test_viewHomePage_returnsCorrectView() {
		// Arrange
		String expected = "index.html";
		// Action
		String actual = appController.viewHomePage();
		// Assert
		assertEquals(expected, actual);
	}

	@Test
	void test_showSignUpForm_returnsCorrectView() {
		// Arrange
		String expected = "signup_form.html";
		// Action
		String actual = appController.showSignUpForm(modelMock);
		// Assert
		assertEquals(expected, actual);

	}

	@Test
	void test_processRegistration_returnsCorrectView() {
		// Arrange
		String expected = "register_success.html";
		// Action
		String actual = appController.processRegistration(member);
		// Assert
		assertEquals(expected, actual);
	}

	@Test
	void test_processEdit_returnsCorrectView() {
//		// Arrange
//		String expected = "edit_success.html";
//		// Action
//		memberRepository.save(member);
//		String actual = appController.processEdit(member);
//		// Assert
//		assertEquals(expected, actual);
//	}

		// Arrange
		appController.processEdit(member);
		
		// Action
//		memberService.save(member);

		// Assert
		verify(memberService, times(1)).save(member);
	}

	@Test
	void test_showUpdateForm_returnsCorrectView() {
		// Arrange
		String expected = "members.html";
		// Action
		String actual = appController.viewMembersList();
		// Assert
		assertEquals(expected, actual);
	}

}
