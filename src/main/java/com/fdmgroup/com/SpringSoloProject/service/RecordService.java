package com.fdmgroup.com.SpringSoloProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.core.Authentication;
import com.fdmgroup.com.SpringSoloProject.dal.MemberRepository;
import com.fdmgroup.com.SpringSoloProject.dal.RecordRepository;
import com.fdmgroup.com.SpringSoloProject.model.Record;

@Service
public class RecordService {
	
	
	private RecordRepository recordRepo;
	private MemberRepository memberRepo;

	@Autowired
		public RecordService(RecordRepository recordRepo) {
			super();
			this.recordRepo = recordRepo;
		}

	public Record findById(Long id) {
		try {
			return (this.recordRepo.findById(id))
					.orElseThrow(() -> new Exception("Record with id: " + id + " cannot be found"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Record> findByMemberId(Long id){
//		Long id = memberRepo.findByEmail(auth.getName()).getMemberId();
		return this.recordRepo.findByMemberId(id);
		
	}

	/**
	 * It is a method to find all members
	 * @return
	 */
	public List<Record> findAll() {
		return this.recordRepo.findAll();
	}
	
	public Record save(Record record) {
		return recordRepo.save(record);
		
	}
	
	
}
