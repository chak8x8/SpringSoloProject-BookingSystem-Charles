package com.fdmgroup.com.SpringSoloProject.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Record {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recordId;
	
	@ManyToOne
	@JoinColumn(name = "fk_member_id")
	private Member member;
	
	private Date startDate;
	private Date endDate;
	private boolean isReviewed;
	
	@Override
	public String toString() {
		return "Record [recordId=" + recordId + ", member=" + member + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}

	public Record(Member member, Date startDate, Date endDate, boolean isReviewed) {
		super();
		this.member = member;
		this.startDate = startDate;
		this.endDate = endDate;
		this.setReviewed(isReviewed);
	}

	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isReviewed() {
		return isReviewed;
	}

	public void setReviewed(boolean isReviewed) {
		this.isReviewed = isReviewed;
	}
	
	
}


//@Entity
//public class Record {
//	
//	@Id
//	@GeneratedValue
//	private Long recordId;
//	
//	
//	private Long memberId;
//	private Long roomId;
//	private Date startDate;
//	private Date endDate;
//	
//	public Record(Long memberId, Long roomId, Date startDate, Date endDate) {
//		super();
//		this.memberId = memberId;
//		this.roomId = roomId;
//		this.startDate = startDate;
//		this.endDate = endDate;
//	}
//
//	public Record() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public String toString() {
//		return "Record [recordId=" + recordId + ", memberId=" + memberId + ", roomId=" + roomId + ", startDate="
//				+ startDate + ", endDate=" + endDate + "]";
//	}
//
//	public Long getRecordId() {
//		return recordId;
//	}
//
//	public void setRecordId(Long recordId) {
//		this.recordId = recordId;
//	}
//
//	public Long getMemberId() {
//		return memberId;
//	}
//
//	public void setMemberId(Long memberId) {
//		this.memberId = memberId;
//	}
//
//	public Long getRoomId() {
//		return roomId;
//	}
//
//	public void setRoomId(Long roomId) {
//		this.roomId = roomId;
//	}
//
//	public Date getStartDate() {
//		return startDate;
//	}
//
//	public void setStartDate(Date startDate) {
//		this.startDate = startDate;
//	}
//
//	public Date getEndDate() {
//		return endDate;
//	}
//
//	public void setEndDate(Date endDate) {
//		this.endDate = endDate;
//	}
//	
//	
//}
//
