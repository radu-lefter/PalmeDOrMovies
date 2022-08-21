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
	
	//GET mappings
	@GetMapping("/")
	public String greeting() { return "Welcome to Palme D'Or Movies. Enjoy our selection of the best movies.";}
	
	@GetMapping("/allmovies")  
	private List<Nominees> getAllMovies()   
	{  
	return nomineesService.getAllMovies();  
	}
	
	@GetMapping("/getmovieyear/{year}")  
	private List<Nominees> getMovieByYear(@PathVariable("year") int year)   
	{  
	return nomineesService.getMoviesByYear(year);  
	}
	
	@GetMapping("/getmoviegenre/{genre}")  
	private List<Nominees> getMoviesByGenre(@PathVariable("genre") String genre)   
	{  
	return nomineesService.getMoviesByGenre(genre);  
	}
	
	@GetMapping("/getmovieafteryear/{year}")  
	private List<Nominees> getMoviesAfterYear(@PathVariable("year") int year)   
	{  
	return nomineesService.getMoviesAfterYear(year);  
	}
	
	@GetMapping("/getmovie/{movieid}")  
	private Nominees getMovieById(@PathVariable("movieid") int movieid)   
	{  
	return nomineesService.getMovieById(movieid);  
	}
	
	//POST mappings
	@PostMapping("/createmovie")  
	private int saveMovie(@RequestBody Nominees movie)   
	{  
		nomineesService.createOrUpdateMovie(movie);  
	    return movie.getId();  
	}
	
	//PUT mappings
	@PutMapping("/updatemovie")  
	private Nominees update(@RequestBody Nominees movie)   
	{  
		nomineesService.createOrUpdateMovie(movie);  
	    return movie;  
	}
	
	@PutMapping("/updtitle/{title}&{id}")  
	private void updateIsbn(@PathVariable("title") String title, @PathVariable("id") int id)   
	{  
		nomineesService.updateTitle(title, id);  

	}
	
	//DELETE mappings
	@DeleteMapping("/deletemovie/{movieid}")  
	private void deleteMovie(@PathVariable("movieid") int movieid)   
	{  
		nomineesService.deleteMovie(movieid);  
	}

}
