package com.qaproject.palmedor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.qaproject.palmedor.exceptions.NomineeNotFoundId;
import com.qaproject.palmedor.exceptions.NomineesNotFound;
import com.qaproject.palmedor.exceptions.NomineesNotFoundByGenre;
import com.qaproject.palmedor.exceptions.NomineesNotFoundByYear;
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
	if(CollectionUtils.isEmpty(movies)) {
		throw new NomineesNotFound();
	}
	return movies;  
	}
	
	public Nominees getMovieById(int id) {
		//return nomineesRepository.findById(id).get(); 
		Nominees found = this.nomineesRepository.findById(id).orElseThrow(NomineeNotFoundId::new);
	    return found;
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
	if(CollectionUtils.isEmpty(movies)) {
		throw new NomineesNotFoundByGenre();
	}
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
	if(CollectionUtils.isEmpty(movies)) {
		throw new NomineesNotFoundByYear();
	}
	return movies;  
	}
	
	//update functions
	public void updateTitle(String title, int id)   
	{  
		nomineesRepository.updTitle(title, id);  
	} 
	
	
	//create functions
	public int createOrUpdateMovie(Nominees movie)   
	{  
        nomineesRepository.save(movie);	
        return 1;
	}
	
    //delete functions
	public void deleteMovie(int id)   
	{  
		nomineesRepository.deleteById(id);  
	} 

}
