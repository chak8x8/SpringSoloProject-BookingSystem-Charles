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
	
//	@GetMapping
//	public String getMoviePage(@RequestParam Long id, Model model) {
//		System.out.println("Trying to find movie: " + id);
//		Movie foundMovie = this.movieService.findById(id);
//		System.out.println(foundMovie);
//		model.addAttribute("foundMovie",foundMovie);
//		return "Movie.html";
//	}
	
	@GetMapping("all")
	public String getMoviesPage(Model model) {
		List<Movie> movies = this.movieService.findAll();
		model.addAttribute("movies", movies);
		return "Movies";
	}
	
	@GetMapping("/movie/{id}")
	public String getMoviesPageById(@PathVariable(name="id") Long id, Model model) {
		Movie foundMovie = this.movieService.findById(id);
		System.out.println(foundMovie);
		model.addAttribute("foundMovie",foundMovie);
		return "Movie";
	}
	
	
	@GetMapping("/addMovieForm")
	public String addMovieForm(Model model) {
		Movie newMovie = new Movie();
		model.addAttribute("movie", newMovie);
		return "editMovie";
	}
	
	@PostMapping("/saveMovie")
	public String saveMovie(@ModelAttribute Movie movie) {
		this.movieService.save(movie);
		System.out.println("save method: "+ movie.getId());
		System.out.println(movie);
		return "redirect:/all";
	}
	
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(Model model, @RequestParam Long id) {
		Movie movie = movieService.findById(id);
		model.addAttribute("movie", movie);
		return "editMovie";
	}
	
	@GetMapping("/deleteMovie")
	public String deleteMovie(@RequestParam Long id) {
		this.movieService.deleteById(id);
		return "redirect:/all";
	}
}


