package com.fdmgroup.com.SpringProject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import com.fdmgroup.com.SpringProject.controller.MovieController;
import com.fdmgroup.com.SpringProject.model.Movie;
import com.fdmgroup.com.SpringProject.service.MovieService;

@ExtendWith(MockitoExtension.class)
public class MovieControllerTest {

	@Mock
	private MovieService movieServiceMock;

	@Mock
	private Model modelMock;

	private MovieController movieController;

	@BeforeEach
	public void setup() {
		movieController = new MovieController(movieServiceMock);

	}

	@Test
	void test_getMoviesPage_returnsCorrectView() {
		// Arrange
		String expected = "Movies";
		// Action
		String actual = movieController.getMoviesPage(modelMock);
		// Assert
		assertEquals(expected, actual);
	}

	@Test
	void test_getMoviesPageById_returnsCorrectView() {
		// Arrange
		String expected = "Movie";
		// Action
		String actual = movieController.getMoviesPageById(0L, modelMock);
		// Assert
		assertEquals(expected, actual);

	}

	@Test
	void test_addMovieForm_returnsCorrectView() {
		// Arrange
		String expected = "editMovie";
		// Action
		String actual = movieController.addMovieForm(modelMock);
		// Assert
		assertEquals(expected, actual);
	}

	@Test
	void test_saveMovie_returnsCorrectView() {
		// Arrange
		String expected = "redirect:/all";
		// Action
		Movie movie = new Movie();
		String actual = movieController.saveMovie(movie);
		// Assert
		assertEquals(expected, actual);
	}

	@Test
	void test_showUpdateForm_returnsCorrectView() {
		// Arrange
		String expected = "editMovie";
		// Action
		String actual = movieController.showUpdateForm(modelMock, 0L);
		// Assert
		assertEquals(expected, actual);
	}

	@Test
	void test_deleteMovie_returnsCorrectView() {
		// Arrange
		String expected = "redirect:/all";
		// Action
		String actual = movieController.deleteMovie(0L);
		// Assert
		assertEquals(expected, actual);
	}

}
