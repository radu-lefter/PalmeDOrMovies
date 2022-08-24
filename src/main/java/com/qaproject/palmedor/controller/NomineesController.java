package com.qaproject.palmedor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.qaproject.palmedor.model.Nominees;
import com.qaproject.palmedor.service.NomineesService;

@RestController
public class NomineesController {
	
	@Autowired
	NomineesService nomineesService;
	
	//GET mappings
	@GetMapping("/")
	public String greeting() { return "Welcome to Palme D'Or Movies. Enjoy our selection of the best movies.";}
	
	@GetMapping(value = "/allmovies", produces = MediaType.APPLICATION_JSON_VALUE)  
	private List<Nominees> getAllMovies()   
	{  
	return nomineesService.getAllMovies();  
	}
	

	@GetMapping(value ="/allmoviesapp", produces = MediaType.TEXT_HTML_VALUE) 
	ModelAndView allMovies()
	{
		ModelAndView modelAndView = new ModelAndView("allMovies");
	    modelAndView.addObject("message", nomineesService.getAllMovies());
	    return modelAndView;
	}
	
	@GetMapping(value = "/getmovie/{movieid}", produces = MediaType.APPLICATION_JSON_VALUE)  
	private Nominees getMovieById(@PathVariable("movieid") int movieid)   
	{  
	return nomineesService.getMovieById(movieid);  
	}
	
	@GetMapping(value ="/getmovieapp/{movieid}", produces = MediaType.TEXT_HTML_VALUE) 
	ModelAndView getMovieByIdApp(@PathVariable("movieid") int movieid)
	{
		ModelAndView modelAndView = new ModelAndView("oneMovie");
	    modelAndView.addObject("message", nomineesService.getMovieById(movieid));
	    return modelAndView;
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
	
	
	
	//POST mappings
	@GetMapping(value ="/createmovieform", produces = MediaType.TEXT_HTML_VALUE)  
	ModelAndView saveMovieApp()
	{
		ModelAndView modelAndView = new ModelAndView("createMovie");
		modelAndView.addObject("nominee", new Nominees());
	    //modelAndView.addObject("message", nomineesService.getAllMovies());
	    return modelAndView;
	}
	
	@PostMapping("/createmovie")  
	private int saveMovie(@RequestBody Nominees movie)   
	{  
		nomineesService.createOrUpdateMovie(movie);  
	    return movie.getId();  
	}
	
	@PostMapping("/createmovieapp")  
	private String saveMovieApp(Model model, @ModelAttribute("nominee") Nominees nominee)   
	{  
		nomineesService.createOrUpdateMovie(nominee);  
	    return "registration successful";  
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
