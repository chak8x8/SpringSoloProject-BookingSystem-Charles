package com.fdmgroup.com.SpringProject.dal;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fdmgroup.com.SpringProject.model.Movie;

/**
 * 
 * @author chak8x8
 * It is an interface to allow MovieService class to use.
 */

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

	
//	Optional<Movie> findById(Long id);

	
}
