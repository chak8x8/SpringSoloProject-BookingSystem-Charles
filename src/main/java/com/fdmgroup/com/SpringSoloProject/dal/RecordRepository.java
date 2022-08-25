package com.fdmgroup.com.SpringSoloProject.dal;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.fdmgroup.com.SpringSoloProject.model.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long>{

	Optional<Record> findById(Long id);

	

	@Query("SELECT r FROM Record r WHERE r.member.id =?1")
	List<Record> findByMemberId(Long memberId);
	
//	@Query(nativeQuery = true, value="SQL")
//	List<Record> findAllById(Long id);
	
//	@Query("SELECT r FROM record r WHERE r.start_date =?1")
//	List<Record> findByStartDate(Date startDate);
}