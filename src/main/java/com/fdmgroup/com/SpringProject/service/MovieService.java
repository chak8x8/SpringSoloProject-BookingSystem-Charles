package com.fdmgroup.com.SpringProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.com.SpringProject.dal.MovieRepository;
import com.fdmgroup.com.SpringProject.model.Movie;

/**
 * 
 * @author chak8x8 It is a class to provide business functionalities.
 */
@Service
public class MovieService {
	private MovieRepository movieRepo;

	@Autowired
	public MovieService(MovieRepository movieRepo) {
		super();
		this.movieRepo = movieRepo;
	}

	/**
	 * It is a method to find a movie with specific id.
	 * @param id
	 * @return
	 */
	public Movie findById(Long id) {
		try {
			return (this.movieRepo.findById(id))
					.orElseThrow(() -> new Exception("Movie with id: " + id + " cannot be found"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * It is a method to find all movies
	 * @return
	 */
	public List<Movie> findAll() {
		return this.movieRepo.findAll();
	}

	/**
	 * It is a method to save the new movie in the database, or update the existing movie.
	 * @param movie
	 */
	public void save(Movie movie) {
		this.movieRepo.save(movie);
	}

	/**
	 * It is a method to delete a movie in database.
	 * @param id
	 */
	public void deleteById(Long id) {
		this.movieRepo.deleteById(id);

	}

}
