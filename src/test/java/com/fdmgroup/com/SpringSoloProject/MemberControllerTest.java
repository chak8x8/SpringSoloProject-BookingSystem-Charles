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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.ui.Model;

import com.fdmgroup.com.SpringSoloProject.controller.AppController;
import com.fdmgroup.com.SpringSoloProject.controller.MemberController;
import com.fdmgroup.com.SpringSoloProject.dal.MemberRepository;
import com.fdmgroup.com.SpringSoloProject.model.Member;
import com.fdmgroup.com.SpringSoloProject.service.MemberService;
import com.fdmgroup.com.SpringSoloProject.service.RecordService;

@ExtendWith(MockitoExtension.class)
public class MemberControllerTest {

	@Mock
	private Model modelMock;

	private Member member;

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private RecordService recordService; 

	private MemberController memberController;

	@BeforeEach
	public void setup() {
		memberController = new MemberController(memberService, recordService);
		memberService = new MemberService(memberRepository);
		member = new Member("Peter", "Smith", "peter@fdm.com", new BCryptPasswordEncoder().encode("123456"));
	}

	@Test
	void test_getPreLoginPage_returnsCorrectView() {
		// Arrange
		String expected = "index.html";
		// Action
		String actual = memberController.getPreLoginPage(member);
		// Assert
		assertEquals(expected, actual);
	}

	@Test
	void test_getMemberIndex_returnsCorrectView() {
		// Arrange
		String expected = "member_index.html";
		// Action
		String actual = memberController.getMemberIndex(member);
		// Assert
		assertEquals(expected, actual);

	}

	@Test
	void test_getReservation1_returnsCorrectView() {
		// Arrange
		String expected = "reservation_1.html";
		// Action
		String actual = memberController.getReservation1(member);
		// Assert
		assertEquals(expected, actual);
	}
	
	@Test
	void test_getReservation2_returnsCorrectView() {
		// Arrange
		String expected = "reservation_2.html";
		// Action
		String actual = memberController.getReservation1(member);
		// Assert
		assertEquals(expected, actual);
	}

	@Test
	@WithMockUser(username = "peter@fdm.com", password = "123456")
	void test_editMemberForm_returnsCorrectView() {
		// Arrange

		// Action
		memberController.editMemberForm(modelMock, MockUser).save(member);

		// Assert
		verify(memberRepository, times(1)).save(member);
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
