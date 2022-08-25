package com.fdmgroup.com.SpringSoloProject;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.fdmgroup.com.SpringSoloProject.dal.MemberRepository;
import com.fdmgroup.com.SpringSoloProject.model.Member;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class MemberRepositoryTest {
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private TestEntityManager entityManager;
	
//	@Test
//	public void test_createMember() {
//		Member member = new Member();
//		member.setEmail("abc@msn.com");
//		member.setPassword("password");
//		member.setFirstName("ABC");
//		member.setLastName("DEFG");
//		member.setCreditCard("3345-5567-9900-5511");
//		
//		Member savedMember = memberRepo.save(member);
//		
//		Member existMember = entityManager.find(Member.class, savedMember.getMemberId());
//		
//		assertThat(existMember.getEmail()).isEqualTo(member.getEmail());
//		
//	}
//	
//	@Test
//	public void test_findMemberByEmail() {
//		String email = "abc@msn.com";
//		
//		Member member = memberRepo.findByEmail(email);
//		
//		assertThat(member).isNotNull();
//		}
	}


