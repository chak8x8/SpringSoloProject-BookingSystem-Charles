package com.fdmgroup.com.SpringProject;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.fdmgroup.com.SpringProject.dal.MovieRepository;
import com.fdmgroup.com.SpringProject.model.Movie;


/**
 * 
 * @author chak8x8
 * This class is to allow batch loading of data that is identified by a set of unique keys. 
 * It will pre-load some data to MySQL.
 */
@Service
public class Dataloader implements ApplicationRunner{
	private MovieRepository movieRepo;
	
	@Autowired
	public Dataloader(MovieRepository movieRepo) {
		super();
		this.movieRepo = movieRepo;
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("The program is running");
		Movie movie1 = new Movie("Spiderman", 5, 121, 2002, "Action");
		Movie movie2 = new Movie("Spiderman2", 5, 127, 2004, "Action");
		this.movieRepo.saveAll(Arrays.asList(movie1, movie2));
		
		
		
	}

}