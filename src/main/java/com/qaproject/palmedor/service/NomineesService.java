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
	
	public List<Nominees> getAllMovies()   
	{  
	List<Nominees> movies = new ArrayList<Nominees>();    
	nomineesRepository.findAll().forEach(movies::add);
	return movies;  
	}
	
	public Nominees getMovieById(int id) {
		return nomineesRepository.findById(id).get(); 
	}
	
	public void createOrUpdateMovie(Nominees movie)   
	{  
		nomineesRepository.save(movie);  
	}
	
  
	public void deleteMovie(int id)   
	{  
		nomineesRepository.deleteById(id);  
	} 

}
