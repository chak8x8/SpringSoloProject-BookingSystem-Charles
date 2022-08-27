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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fdmgroup.com.SpringSoloProject.dal.MemberRepository;
import com.fdmgroup.com.SpringSoloProject.model.Member;
import com.fdmgroup.com.SpringSoloProject.service.MemberService;

@SpringBootTest
class MemberServiceTest {

	private MemberService memberService;

	@MockBean
	private MemberRepository memberRepo;

	@Mock
	private Member member;

	@BeforeEach
	public void setup() {
		member = new Member();
		memberService = new MemberService(memberRepo);
		
	}

	@Test
	void test_member_isFoundByID() {
		// Arrange
		when(memberRepo.findById(member.getMemberId())).thenReturn(Optional.of(member));

		// Action
		Member foundMember = memberService.findById(member.getMemberId());

		// Assert
		assertEquals(member.getMemberId(), foundMember.getMemberId());
		verify(memberRepo, times(1)).findById(member.getMemberId());
	}

	@Test
	void test_member_foundByEmail() {
		// Arrange

		// Action
		String email = "abc@abc.com";
		memberService.findByEmail(email);

		// Assert
		verify(memberRepo, times(1)).findByEmail(email);
	}

	@Test
	void test_member_foundAll() {
		// Arrange

		// Action
		memberService.findAll();

		// Assert
		verify(memberRepo, times(1)).findAll();
	}

	@Test
	void test_member_isSaved() {
		// Arrange

		// Action
		memberService.save(member);

		// Assert
		verify(memberRepo, times(1)).save(member);

	}

}
