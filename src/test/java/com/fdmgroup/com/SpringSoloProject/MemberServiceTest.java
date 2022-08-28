package com.fdmgroup.com.SpringSoloProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fdmgroup.com.SpringSoloProject.dal.MemberRepository;
import com.fdmgroup.com.SpringSoloProject.model.Member;
import com.fdmgroup.com.SpringSoloProject.service.MemberService;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {


	private MemberService memberService;
	
	@Mock
	private MemberRepository memberRepo;

	private Member member;

	@BeforeEach
	public void setup() {
		member = new Member("Testing", "testing", "testing@fdm.com", new BCryptPasswordEncoder().encode("123456"));
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
		String email = "abc@abc.com";
		when(memberRepo.findByEmail(email)).thenReturn(member);
		
		// Action
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
