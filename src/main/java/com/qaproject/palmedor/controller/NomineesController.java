package com.qaproject.palmedor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qaproject.palmedor.model.Nominees;
import com.qaproject.palmedor.service.NomineesService;

@RestController
public class NomineesController {
	
	@Autowired
	NomineesService nomineesService;
	
	@GetMapping("/")
	public String greeting() { return "Welcome to Palme D'Or Movies. Enjoy our selection of the best movies.";}
	
	@GetMapping("/allmovies")  
	private List<Nominees> getAllMovies()   
	{  
	return nomineesService.getAllMovies();  
	}
	
	@GetMapping("/getmovie/{movieid}")  
	private Nominees getBooks(@PathVariable("movieid") int movieid)   
	{  
	return nomineesService.getMovieById(movieid);  
	}
	
	
	@PostMapping("/createmovie")  
	private int saveBook(@RequestBody Nominees movie)   
	{  
		nomineesService.createOrUpdateMovie(movie);  
	    return movie.getId();  
	}
	
	@PutMapping("/updatemovie")  
	private Nominees update(@RequestBody Nominees movie)   
	{  
		nomineesService.createOrUpdateMovie(movie);  
	    return movie;  
	}
	
	@DeleteMapping("/deletemovie/{movieid}")  
	private void deleteMovie(@PathVariable("movieid") int movieid)   
	{  
		nomineesService.deleteMovie(movieid);  
	}

}
