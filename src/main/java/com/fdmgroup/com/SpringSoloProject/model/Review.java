package com.fdmgroup.com.SpringSoloProject.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Review {
	
	@Id
	@GeneratedValue
	private Long reviewId;
	
	@OneToOne
	@JoinColumn(name = "fk_record_id")
	private Record record;

	
	private String comment;
	private Date commentDate;

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", record=" + record + ", comment=" + comment + "]";
	}

	public Review(Record record, String comment) {
		super();
		this.record = record;
		this.comment = comment;
	}

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date date) {
		this.commentDate = date;
	}
	
	
	
	
}
