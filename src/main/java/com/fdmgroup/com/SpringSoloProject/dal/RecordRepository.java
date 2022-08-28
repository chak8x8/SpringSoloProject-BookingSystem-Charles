package com.fdmgroup.com.SpringSoloProject.dal;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.fdmgroup.com.SpringSoloProject.model.Record;

/**
 * 
 * @author chak8x8
 * It is an interface to allow RecordService class to use.
 */

@Repository
public interface RecordRepository extends JpaRepository<Record, Long>{

	Optional<Record> findById(Long id);

	

	@Query("SELECT r FROM Record r WHERE r.member.id =?1")
	List<Record> findByMemberId(Long memberId);
	
}