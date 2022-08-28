package com.fdmgroup.com.SpringSoloProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.com.SpringSoloProject.dal.RecordRepository;
import com.fdmgroup.com.SpringSoloProject.model.Record;

/**
 *  It is a class to provide business functionalities.
 *  
 * @author chak8x8
 *
 */
@Service
public class RecordService {
	
	
	private RecordRepository recordRepo;

	@Autowired
		public RecordService(RecordRepository recordRepo) {
			super();
			this.recordRepo = recordRepo;
		}

	/**
	 * It is a method to find a record with specific record id.
	 * @param id
	 * @return
	 */
	public Record findById(Long id) {
		try {
			return (this.recordRepo.findById(id))
					.orElseThrow(() -> new Exception("Record with id: " + id + " cannot be found"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * It is a method to find all records which belong to specific member.
	 * @param id
	 * @return
	 */
	public List<Record> findByMemberId(Long id){
		return this.recordRepo.findByMemberId(id);
		
	}

	/**
	 * It is a method to find all records.
	 * @return
	 */
	public List<Record> findAll() {
		return this.recordRepo.findAll();
	}
	
	/**
	 *  It is a method to save the new record in the database, or update the existing record.
	 * @param record
	 * @return
	 */
	public Record save(Record record) {
		return this.recordRepo.save(record);
		
	}
	
	
}
