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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

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
	@Qualifier("databaseUserService")
	protected UserDetailsService userDetailsService;

	@MockBean
	private MemberRepository memberRepository;

	@Mock
	private MemberService memberService;

	@Mock
	private RecordService recordService;

	@Mock
	Authentication authentication;

	private MemberController memberController;

	@BeforeEach
	public void setup() {
		member = new Member("Peter", "Smith", "peter@fdm.com", new BCryptPasswordEncoder().encode("123456"));
		memberController = new MemberController(memberService, recordService);
		UserDetails user = this.userDetailsService.loadUserByUsername("peter@fdm.com");
		authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
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
		String actual = memberController.getReservation2(member);
		// Assert
		assertEquals(expected, actual);
	}

	@Test
	void test_editMemberForm_returnsCorrectView() {
		// Arrange
		String expected = "editMember.html";
		
		// Action
		System.out.println(authentication.getName());
		String actual = memberController.editMemberForm(modelMock, authentication);
		
		// Assert
		assertEquals(expected, actual);
	}

//	@Test
//	void test_showUpdateForm_returnsCorrectView() {
//		// Arrange
//		String expected = "members.html";
//		// Action
//		String actual = appController.viewMembersList();
//		// Assert
//		assertEquals(expected, actual);
//	}

}
