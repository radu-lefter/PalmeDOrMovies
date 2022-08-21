package com.qaproject.palmedor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qaproject.palmedor.model.Nominees;
import com.qaproject.palmedor.repository.NomineesRepository;

@Service
public class NomineesService {
	
	@Autowired  
	NomineesRepository nomineesRepository;
	
	//get functions
	public List<Nominees> getAllMovies()   
	{  
	List<Nominees> movies = new ArrayList<Nominees>();    
	nomineesRepository.findAll().forEach(movies::add);
	return movies;  
	}
	
	public Nominees getMovieById(int id) {
		return nomineesRepository.findById(id).get(); 
	}
	
	public List<Nominees> getMoviesByWinner(boolean win)   
	{  
	List<Nominees> movies = new ArrayList<Nominees>();    
	nomineesRepository.findNomineesByWinner(win).forEach(movies::add);
	return movies;  
	}
	
	public List<Nominees> getMoviesByGenre(String genre)   
	{  
	List<Nominees> movies = new ArrayList<Nominees>();    
	nomineesRepository.findByGenreContaining(genre).forEach(movies::add);
	return movies;  
	}
	
	public List<Nominees> getMoviesAfterYear(int year)   
	{  
	List<Nominees> movies = new ArrayList<Nominees>();    
	nomineesRepository.findByYearGreaterThan(year).forEach(movies::add);
	return movies;  
	}
	
	public List<Nominees> getMoviesByYear(int year)   
	{  
	List<Nominees> movies = new ArrayList<Nominees>();    
	nomineesRepository.findNomineesByYear(year).forEach(movies::add);
	return movies;  
	}
	
	//update functions
	public void updateTitle(String title, int id)   
	{  
		nomineesRepository.updTitle(title, id);  
	} 
	
	
	//create functions
	public void createOrUpdateMovie(Nominees movie)   
	{  
		nomineesRepository.save(movie);  
	}
	
    //delete functions
	public void deleteMovie(int id)   
	{  
		nomineesRepository.deleteById(id);  
	} 

}
