package com.fdmgroup.com.SpringProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.com.SpringProject.model.Movie;
import com.fdmgroup.com.SpringProject.service.MovieService;


/**
 * 
 * @author chak8x8
 *
 * This class is to return the view to be rendered as a response.
 */

@Controller
public class MovieController {
	private MovieService movieService;
	
	@Autowired
	public MovieController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}
	
	/**
	 * It is a method that the address is all and it calls the findAll method and redirect to Movies page.
	 * @param model
	 * @return
	 */
	@GetMapping("all")
	public String getMoviesPage(Model model) {
		List<Movie> movies = this.movieService.findAll();
		model.addAttribute("movies", movies);
		return "Movies";
	}
	
	/**
	 * It is a method that the address is /movie/{id} and it calls the findByID method and redirect to Movie page.
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/movie/{id}")
	public String getMoviesPageById(@PathVariable(name="id") Long id, Model model) {
		Movie foundMovie = this.movieService.findById(id);
		System.out.println(foundMovie);
		model.addAttribute("foundMovie",foundMovie);
		return "Movie";
	}
	
	/**
	 *  It is a method that the address is /addMovieForm and it loads the new input and redirect to editMovie.
	 * @param model
	 * @return
	 */
	@GetMapping("/addMovieForm")
	public String addMovieForm(Model model) {
		Movie newMovie = new Movie();
		model.addAttribute("movie", newMovie);
		return "editMovie";
	}
	
	/**
	 * It is method to call save method and save the data in database and direct back to Movies page.
	 * @param movie
	 * @return
	 */
	@PostMapping("/saveMovie")
	public String saveMovie(@ModelAttribute Movie movie) {
		this.movieService.save(movie);
		return "redirect:/all";
	}
	
	
	/**
	 * It is a method that the address is /showUpdateForm and it calls the findByID method and redirect to editMovie page.
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(Model model, @RequestParam Long id) {
		Movie movie = movieService.findById(id);
		model.addAttribute("movie", movie);
		return "editMovie";
	}
	
	/**
	 * It is a method to call the deleteByID method to delete a selected data in database and redirect back to Movies page.
	 * @param id
	 * @return
	 */
	@GetMapping("/deleteMovie")
	public String deleteMovie(@RequestParam Long id) {
		this.movieService.deleteById(id);
		return "redirect:/all";
	}
}


