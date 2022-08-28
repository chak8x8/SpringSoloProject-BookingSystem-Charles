package com.fdmgroup.com.SpringSoloProject.dal;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fdmgroup.com.SpringSoloProject.model.Review;

/**
 * 
 * @author chak8x8
 * It is an interface to allow ReviewService class to use.
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{

	Optional<Review> findById(Long id);
	
	@Query("SELECT r FROM Review r WHERE r.record.id =?1")
	List<Review> findByRecordId(Long recordId);
	
}