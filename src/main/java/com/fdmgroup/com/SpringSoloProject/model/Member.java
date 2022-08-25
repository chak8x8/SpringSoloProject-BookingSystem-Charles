package com.fdmgroup.com.SpringSoloProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId;
	
	@Column(nullable = false, length = 20)
	private String firstName;
	
	@Column(nullable = false, length = 20)
	private String lastName;
	
	@Column(nullable = false, unique = true, length = 45)
	private String email;
	
	@Column(nullable = false, length = 640)
	private String password;
	
	private String creditCard;
	

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Member(String firstName, String lastName, String email, String password, String creditCard) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.creditCard = creditCard;
	}


	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", creditCard=" + creditCard + "]";
	}


	public Long getMemberId() {
		return memberId;
	}


	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCreditCard() {
		return creditCard;
	}


	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	

	
	

}
