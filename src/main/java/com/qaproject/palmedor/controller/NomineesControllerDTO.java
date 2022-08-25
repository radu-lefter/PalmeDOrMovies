package com.qaproject.palmedor.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qaproject.palmedor.dto.NomineesDTO;
import com.qaproject.palmedor.model.Nominees;
import com.qaproject.palmedor.service.NomineesServiceDTO;

@RestController
public class NomineesControllerDTO {
	
	@Autowired
	NomineesServiceDTO nomineesServiceDTO;
	
	public NomineesControllerDTO(NomineesServiceDTO nomineesServiceDTO) {
		 super();
	     this.nomineesServiceDTO = nomineesServiceDTO;
	}
	
	@GetMapping("/allmoviesDTO")
    public List<Nominees> getAllMovies() {
        return this.nomineesServiceDTO.getAllMovies();
    }
	
	@PostMapping("/createmovieDTO")
    public NomineesDTO addNominee(@RequestBody Nominees nominee) {
        return this.nomineesServiceDTO.addNominee(nominee);
    }
	
	
	@PutMapping("/updatemovieDTO")
    public NomineesDTO updatePerson(@PathParam("id") int id, @RequestBody Nominees person) {
        return this.nomineesServiceDTO.updateNominee(id, person);
    }
	
	@DeleteMapping("/deletemovieDTO/{id}")
    public boolean removePerson(@PathVariable int id) {
        return this.nomineesServiceDTO.removeNominee(id);
    }

}
