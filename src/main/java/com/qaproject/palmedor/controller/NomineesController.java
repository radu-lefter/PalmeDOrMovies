package com.qaproject.palmedor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.qaproject.palmedor.exceptions.NomineesNotFoundByWinner;
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
	public List<Nominees> getAllMovies()   
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
	public Nominees getMovieById(@PathVariable("movieid") int movieid)   
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
	public List<Nominees> getMovieByYear(@PathVariable("year") int year)   
	{  
	return nomineesService.getMoviesByYear(year);  
	}
	
	@GetMapping("/getmoviegenre/{genre}")  
	public List<Nominees> getMoviesByGenre(@PathVariable("genre") String genre)   
	{  
	return nomineesService.getMoviesByGenre(genre);  
	}
	
	@GetMapping("/getmovieafteryear/{year}")  
	public List<Nominees> getMoviesAfterYear(@PathVariable("year") int year)   
	{  
	return nomineesService.getMoviesAfterYear(year);  
	}
	
	@GetMapping("/getmoviebywinners/{win}")  
	public List<Nominees> getMoviesByWinners(@PathVariable("win") String win)   
	{  
	     if(win.equals("true") || win.equals("false")) {
	    	 boolean winBool = Boolean.parseBoolean(win);
		     return nomineesService.getMoviesByWinner(winBool);  
		}else {
			throw new NomineesNotFoundByWinner();
		}
	}
	
	@GetMapping(value ="/createmovieform", produces = MediaType.TEXT_HTML_VALUE)  
	ModelAndView saveMovieApp()
	{
		ModelAndView modelAndView = new ModelAndView("createMovie");
		modelAndView.addObject("nominee", new Nominees());
	    //modelAndView.addObject("message", nomineesService.getAllMovies());
	    return modelAndView;
	}
	
	//POST mappings
	
	
	@PostMapping("/createmovie")  
	public Nominees saveMovie(@RequestBody Nominees movie)   
	{  
		nomineesService.createOrUpdateMovie(movie);  
	    return movie; 
	}
	
	@PostMapping("/createmovieapp")  
	private String saveMovieAppSuccess(Model model, @ModelAttribute("nominee") Nominees nominee)   
	{  
		nomineesService.createOrUpdateMovie(nominee);  
	    return "registration successful";  
	}
	
	
	//PUT mappings
	@PutMapping("/updatemovie")  
	public Nominees update(@RequestBody Nominees movie)   
	{  
		nomineesService.createOrUpdateMovie(movie);  
	    return movie;  
	}
	
	@PutMapping("/updtitle/{title}&{id}")  
	public Nominees updateTitle(@PathVariable("title") String title, @PathVariable("id") int id)   
	{  
		return nomineesService.updateTitle(title, id);  

	}
	
	//DELETE mappings
	@DeleteMapping("/deletemovie/{movieid}")  
	public int deleteMovie(@PathVariable("movieid") int movieid)   
	{  
		nomineesService.deleteMovie(movieid); 
		return 0;
	}

}
