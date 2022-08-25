package com.qaproject.palmedor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


import com.qaproject.palmedor.dto.NomineesDTO;
import com.qaproject.palmedor.exceptions.NomineesNotFound;
import com.qaproject.palmedor.model.Nominees;
import com.qaproject.palmedor.repository.NomineesRepository;

@Service
public class NomineesServiceDTO {
	
	@Autowired
	private NomineesRepository nomineesRepo;
	
	private ModelMapper mapper;
	
	public NomineesServiceDTO(NomineesRepository repo, ModelMapper mapper) {
        super();
        this.nomineesRepo = repo;
        this.mapper = mapper;
    }
	
	private NomineesDTO mapToDTO(Nominees nominees) {
		return this.mapper.map(nominees, NomineesDTO.class);
		}
	
	public List<Nominees> getAllMovies()   
	{  
	List<Nominees> movies = new ArrayList<Nominees>();    
	nomineesRepo.findAll().forEach(movies::add);
	if(CollectionUtils.isEmpty(movies)) {
		throw new NomineesNotFound();
	}
	return movies;  
	}
	
	public NomineesDTO addNominee(Nominees nominee) {
		Nominees saved =  this.nomineesRepo.save(nominee);
        return this.mapToDTO(saved);
    }
	
	public NomineesDTO updateNominee(int id, Nominees newNominee) {
        Optional<Nominees> existingOptional = this.nomineesRepo.findById(id);
        Nominees existing = existingOptional.get();

        existing.setTitle(newNominee.getTitle());
        existing.setDirector(newNominee.getDirector());

        Nominees updated =  this.nomineesRepo.save(existing);
        return this.mapToDTO(updated);
        
	}
	
	public boolean removeNominee(int id) {
        this.nomineesRepo.deleteById(id);
        boolean exists = this.nomineesRepo.existsById(id);
        return !exists;
    }

}
