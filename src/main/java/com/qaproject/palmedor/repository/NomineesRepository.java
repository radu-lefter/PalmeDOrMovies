package com.qaproject.palmedor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.qaproject.palmedor.model.Nominees;

public interface NomineesRepository extends CrudRepository<Nominees, Integer>{
	
	List<Nominees> findNomineesByWinner(boolean win);
	
	List<Nominees> findNomineesByYear(int year);
	
	List<Nominees> findByGenreContaining(String infix);
	
	List<Nominees> findByYearGreaterThan(int year);
	
	@Modifying
	@Transactional
	@Query("UPDATE Nominees SET title = ?1  WHERE id = ?2")
	void updTitle(String title, int id);

}
