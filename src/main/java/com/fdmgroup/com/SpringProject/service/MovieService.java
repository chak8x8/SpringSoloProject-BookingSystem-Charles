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

	public Movie findById(Long id) {
		try {
			return (this.movieRepo.findById(id))
					.orElseThrow(() -> new Exception("Movie with id: " + id + " cannot be found"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Movie> findAll() {
		return this.movieRepo.findAll();
	}

	public void save(Movie movie) {
		if (!this.movieRepo.existsById(movie.getId())) {
			Movie updateMovie = this.findById(movie.getId());
			updateMovie.setTitle(movie.getTitle());
			updateMovie.setRuntime(movie.getRuntime());
			updateMovie.setReleaseYear(movie.getReleaseYear());
			updateMovie.setRating(movie.getRating());
			updateMovie.setGenre(movie.getGenre());
			this.movieRepo.save(updateMovie);
		} else
			this.movieRepo.save(movie);

	}

	public void deleteById(Long id) {
		this.movieRepo.deleteById(id);

	}

}
