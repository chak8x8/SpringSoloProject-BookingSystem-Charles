package com.fdmgroup.com.SpringProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import com.fdmgroup.com.SpringProject.dal.MovieRepository;
import com.fdmgroup.com.SpringProject.model.Movie;
import com.fdmgroup.com.SpringProject.service.MovieService;

@SpringBootTest
class SpringProjectApplicationTests {
	
	@Autowired	
	private MovieService movieService;
	@MockBean
	private MovieRepository mRepo;
	
//	@Test
//	void contextLoads() {
//	}
//	
//	@Test
//	void test_movie_isSave() {
//		
//		Movie movie = new Movie("Title", 5, 30, 1900, "Testing"); 
//		mRepo.save(movie);
//		System.out.println(movie.getId());
//		assertEquals(movie, mRepo.findById(movie.getId()).orElse(null));
////		assertEquals(movie.getId(), mRepo.findById(movie.getId()).orElse(null).getId());
//		mRepo.delete(movie);
//	}
//	
//	@Test
//	void test_moive_isUpdated() {
//		Movie movie = new Movie("Title", 5, 30, 1900, "Testing"); 
//		mRepo.save(movie);
//		assertEquals(movie, mRepo.findById(movie.getId()).orElse(null));
//		movie.setTitle("Title2");
//		mRepo.save(movie);
//		assertEquals(movie, mRepo.findById(movie.getId()).orElse(null));
//		mRepo.delete(movie);
//	}
//	
//	@Test
//	void test_moive_isDeleted() {
//		Movie movie = new Movie("Title", 5, 30, 1900, "Testing"); 
//		mRepo.save(movie);
//		assertEquals(movie, mRepo.findById(movie.getId()).orElse(null));
//		mRepo.delete(movie);
//		assertEquals(null, mRepo.findById(movie.getId()).orElse(null));
//		
//	}
//	
//	@Test
//	void test_moive_isFoundByID() {
//		Movie movie = new Movie("Title", 5, 30, 1900, "Testing"); 
//		mRepo.save(movie);
//		assertEquals(movie, mRepo.findById(movie.getId()).orElse(null));
//		mRepo.delete(movie);
//		
//	}
//	
//	@Test
//	void test_moive_isFoundByTitle() {
//		Movie movie = new Movie("Title", 5, 30, 1900, "Testing"); 
//		mRepo.save(movie);
//		//assertEquals(movie, mRepo.findByTitle(movie.getTitle()).get(0));;
//		assertTrue(mRepo.findByTitle(movie.getTitle()).size()>0);
//		mRepo.delete(movie);
//		
//	}
//	
//	@Test
//	void test_moive_isFoundByRating() {
//		Movie movie = new Movie("Title", 5, 30, 1900, "Testing"); 
//		mRepo.save(movie);
//		//assertEquals(movie, mRepo.findByTitle(movie.getTitle()).get(0));;
//		assertTrue(mRepo.findByRating(movie.getRating()).size()>0);
//		mRepo.delete(movie);
//	}
//
//	@Test
//	void test_moive_isFoundByRuntime() {
//		Movie movie = new Movie("Title", 5, 30, 1900, "Testing"); 
//		mRepo.save(movie);
//		//assertEquals(movie, mRepo.findByTitle(movie.getTitle()).get(0));;
//		assertTrue(mRepo.findByRuntime(movie.getRuntime()).size()>0);
//		mRepo.delete(movie);
//	}
//	
//	@Test
//	void test_moive_isFoundByReleaseYear() {
//		Movie movie = new Movie("Title", 5, 30, 1900, "Testing"); 
//		mRepo.save(movie);
//		//assertEquals(movie, mRepo.findByTitle(movie.getTitle()).get(0));;
//		assertTrue(mRepo.findByReleaseYear(movie.getReleaseYear()).size()>0);
//		mRepo.delete(movie);
//	}
	
	@Test
	void test_getHomePage_returnsCorrectView() throws Exception{
		
		//mvc.perform(MockMvcRequestBuilders.get("/all")).andExpect(MockMvcResultMatchers.view().name("Movies"));
	}
	
}
