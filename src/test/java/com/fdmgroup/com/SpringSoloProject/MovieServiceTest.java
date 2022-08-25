package com.fdmgroup.com.SpringSoloProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fdmgroup.com.SpringSoloProject.dal.MovieRepository;
import com.fdmgroup.com.SpringSoloProject.model.Movie;
import com.fdmgroup.com.SpringSoloProject.service.MovieService;

@SpringBootTest
class MovieServiceTest {

	private MovieService movieService;

	@MockBean
	private MovieRepository mRepo;

	private Movie movie;

	@BeforeEach
	public void setup() {
		movie = new Movie("Title", 5, 30, 1900, "Testing");
		movieService = new MovieService(mRepo);
	}

	@Test
	void test_moive_isFoundByID() {
		// Arrange
		when(mRepo.findById(movie.getId())).thenReturn(Optional.of(movie));

		// Action
		Movie foundMovie = movieService.findById(movie.getId());

		// Assert
		assertEquals(movie.getId(), foundMovie.getId());
		verify(mRepo, times(1)).findById(movie.getId());
	}

	@Test
	void test_movie_isSave() {
		// Arrange

		// Action
		movieService.save(movie);

		// Assert
		verify(mRepo, times(1)).save(movie);
	}

	@Test
	void test_moive_isDeleted() {
		// Arrange

		// Action
		movieService.deleteById(movie.getId());

		// Assert
		verify(mRepo, times(1)).deleteById(movie.getId());

	}

}
