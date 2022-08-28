package com.qaproject.palmedor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.qaproject.palmedor.controller.NomineesController;
import com.qaproject.palmedor.model.Nominees;
import com.qaproject.palmedor.model.Reviews;
import com.qaproject.palmedor.repository.NomineesRepository;
import com.qaproject.palmedor.service.NomineesService;

@SpringBootTest
@AutoConfigureMockMvc
//@Sql(scripts = { "classpath:nominees-schema.sql",
//"classpath:nominees-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
@ContextConfiguration(classes= {NomineesService.class})
@ExtendWith(SpringExtension.class)
class PalmeDOrMoviesApplicationTests {
	

	@Autowired
    private NomineesService nomineesService;
	
	@Autowired
    private NomineesService nomineesServiceDTO;
    
	@MockBean
    private NomineesRepository nomineesRepo;
	
    
    @Autowired
    private MockMvc mock;
    
    
    private final Nominees TEST_MOVIE =  new Nominees(100, "Test Title 4", "", 1975, "Test Director 1", "Germany", "German", "Test plot 4",
            "test link", 57, "drama", true, Arrays.asList(new Reviews()));
    
//    @Autowired
//    private ModelMapper mapper;
//    
//   @Autowired
//    private ObjectMapper obmapper;
    
    
  //---------- Unit Tests ----------//   
    
    //Unit Test 1 - Create movie
	@Test
	void testCreateOrUpdateMovie(){
	    
		final Reviews review= new Reviews();
		List<Reviews> list = new ArrayList<>();
		list.add(review);
	
	    final Nominees TEST_MOVIE = new Nominees(0, "Test Title 4", "", 1975, "Test Director 1", "Germany", "German", "Test plot 4",
	            "test link", 57, "drama", true, list);
	    final Nominees TEST_SAVED_MOVIE =  new Nominees(1, "Test Title 4", "", 1975, "Test Director 1", "Germany", "German", "Test plot 4",
	            "test link", 57, "drama", true, list);
	    // WHEN
	    Mockito.when(this.nomineesRepo.save(TEST_MOVIE)).thenReturn(TEST_SAVED_MOVIE);
	    // THEN
	    Assertions.assertThat(this.nomineesService.createOrUpdateMovie(TEST_MOVIE)).isEqualTo(TEST_SAVED_MOVIE);
	    // verify that our repo was accessed exactly once
	    Mockito.verify(this.nomineesRepo, Mockito.times(1)).save(TEST_MOVIE);
	    
	    System.out.println("Test for creating Movie Successful");
	    
	}
    
    //Unit Test 2 - Get movie by id
	@Test
	void testGetMovieById() {
		
	
	    int id = 1001;
	    final Nominees TEST_MOVIE = new Nominees(id, "Test Title 4", "", 1975, "Test Director 1", "Germany", "German", "Test plot 4",
	            "test link", 57, "drama", true, Arrays.asList(new Reviews()));
	    Optional<Nominees> optionalMovie = Optional.of(TEST_MOVIE);
	    this.nomineesRepo.save(TEST_MOVIE);
	    // WHEN
		Mockito.when(this.nomineesRepo.findById(id)).thenReturn(optionalMovie); 
		//THEN
		Assertions.assertThat(this.nomineesService.getMovieById(id)).isEqualTo(TEST_MOVIE);
		
	   System.out.println("Test for Geting Movie By ID Successful");
	   
	}   
	
	
	//Unit Test 3 - Delete movie by id
    @Test
    public void testDeleteMovie() {
    	
    	
    	int id = 1001;
	    final Nominees TEST_MOVIE =  new Nominees(id, "Test Title 4", "", 1975, "Test Director 1", "Germany", "German", "Test plot 4",
	            "test link", 57, "drama", true, Arrays.asList(new Reviews()));
        
	    nomineesService.deleteMovie(TEST_MOVIE.getId());

        Mockito.verify(nomineesRepo, Mockito.times(1))
                .deleteById(TEST_MOVIE.getId());
        
        System.out.println("Test for Delete By ID Successful");
        
    }
    
    //Unit Test 4 - Find all movies
    @Test
    public void testGetAllMovies() {
    	
    	final Nominees TEST_MOVIE = new Nominees(1000, "Test Title 4", "", 1975, "Test Director 1", "Germany", "German", "Test plot 4",
	            "test link", 57, "drama", true, Arrays.asList(new Reviews()));
    	
    	List<Nominees> movies = new ArrayList<>();
    	movies.add(TEST_MOVIE);
    	
    	// WHEN
	    Mockito.when(this.nomineesRepo.findAll()).thenReturn(movies);
	    // THEN
	    Assertions.assertThat(this.nomineesService.getAllMovies()).isEqualTo(movies);
	    // verify that our repo was accessed exactly once
	    Mockito.verify(this.nomineesRepo, Mockito.times(1)).findAll();
	    
	    System.out.println("Test for finding all Movies Successful");
    	  	
    }
    
    //Unit Test 5 - Find movies that won
    @Test
    public void testGetMoviesByWinner() {
    	

	    final Nominees TEST_MOVIE = new Nominees(1001, "Test Title 4", "", 1975, "Test Director 1", "Germany", "German", "Test plot 4",
	            "test link", 57, "drama", true, Arrays.asList(new Reviews()));
	    
	    List<Nominees> movies = new ArrayList<>();
    	movies.add(TEST_MOVIE);
    	
	    // WHEN
		Mockito.when(this.nomineesService.getMoviesByWinner(true)).thenReturn(movies); 
		//THEN
		Assertions.assertThat(this.nomineesService.getMoviesByWinner(true)).isEqualTo(movies);
		
	   System.out.println("Test for Geting Movie if Winner");
    	  	
    }
    
  //Unit Test 6 - Find movies that won
    @Test
    public void testGetMoviesByGenre() {
    	

	    final Nominees TEST_MOVIE = new Nominees(1001, "Test Title 4", "", 1975, "Test Director 1", "Germany", "German", "Test plot 4",
	            "test link", 57, "drama", true, Arrays.asList(new Reviews()));
	    
	    List<Nominees> movies = new ArrayList<>();
    	movies.add(TEST_MOVIE);
    	
	    // WHEN
		Mockito.when(this.nomineesRepo.findByGenreContaining("drama")).thenReturn(movies); 
		//THEN
		Assertions.assertThat(this.nomineesService.getMoviesByGenre("drama")).isEqualTo(movies);
		
	   System.out.println("Test for Geting Movie by Genre");
    	  	
    }
    
  //Unit Test 7 - Find movies after a certain year
    @Test
    public void testGetMoviesAfterYear() {
    	

	    final Nominees TEST_MOVIE = new Nominees(1001, "Test Title 4", "", 1975, "Test Director 1", "Germany", "German", "Test plot 4",
	            "test link", 57, "drama", true, Arrays.asList(new Reviews()));
	    
	    List<Nominees> movies = new ArrayList<>();
    	movies.add(TEST_MOVIE);
    	
	    // WHEN
		Mockito.when(this.nomineesRepo.findByYearGreaterThan(1970)).thenReturn(movies); 
		//THEN
		Assertions.assertThat(this.nomineesService.getMoviesAfterYear(1970)).isEqualTo(movies);
		
	   System.out.println("Test for Geting Movie after  certain Year");
    	  	
    }
    
  //Unit Test 8 - Find movies by year
    @Test
    public void testGetMoviesByYear() {
    	

	    final Nominees TEST_MOVIE = new Nominees(1001, "Test Title 4", "", 1975, "Test Director 1", "Germany", "German", "Test plot 4",
	            "test link", 57, "drama", true, Arrays.asList(new Reviews()));
	    
	    List<Nominees> movies = new ArrayList<>();
    	movies.add(TEST_MOVIE);
    	
	    // WHEN
		Mockito.when(this.nomineesRepo.findNomineesByYear(1975)).thenReturn(movies); 
		//THEN
		Assertions.assertThat(this.nomineesService.getMoviesByYear(1975)).isEqualTo(movies);
		
	   System.out.println("Test for Geting Movie by Year");
    	  	
    }
    
  //Unit Test 9 - Update Title of Movies
    @Test
    public void testUpdateTitle() {
    	

	    final Nominees TEST_MOVIE = new Nominees(1001, "Test Title", "", 1975, "Test Director 1", "Germany", "German", "Test plot 4",
	            "test link", 57, "drama", true, Arrays.asList(new Reviews()));

    	
	    // WHEN
		Mockito.when(this.nomineesRepo.updTitle("Test Title", 1001)).thenReturn(TEST_MOVIE); 
		//THEN
		Assertions.assertThat(this.nomineesService.updateTitle("Test Title", 1001)).isEqualTo(TEST_MOVIE);
		
	   System.out.println("Test for updating only title from record");
    	  	
    }

    
    
  //Unit Test 10 - Get all movies DTO
    @Test
    public void testGetAllMoviesDTO() {
    	
    	final Nominees TEST_MOVIE = new Nominees(1000, "Test Title 4", "", 1975, "Test Director 1", "Germany", "German", "Test plot 4",
	            "test link", 57, "drama", true, Arrays.asList(new Reviews()));
    	
    	List<Nominees> movies = new ArrayList<>();
    	movies.add(TEST_MOVIE);
    	
    	// WHEN
	    Mockito.when(this.nomineesRepo.findAll()).thenReturn(movies);
	    // THEN
	    Assertions.assertThat(this.nomineesServiceDTO.getAllMovies()).isEqualTo(movies);
	    // verify that our repo was accessed exactly once
	    Mockito.verify(this.nomineesRepo, Mockito.times(1)).findAll();
	    
	    System.out.println("Test for finding all Movies Successful");
    	  	
    }
    
  //Unit Test 11 - Delete movie by id in DTO
    @Test
    public void testDeleteMovieDTO() {
    	
    	
    	int id = 1001;
	    final Nominees TEST_MOVIE =  new Nominees(id, "Test Title 4", "", 1975, "Test Director 1", "Germany", "German", "Test plot 4",
	            "test link", 57, "drama", true, Arrays.asList(new Reviews()));
        
	    nomineesServiceDTO.deleteMovie(TEST_MOVIE.getId());

        Mockito.verify(nomineesRepo, Mockito.times(1))
                .deleteById(TEST_MOVIE.getId());
        
        System.out.println("Test for Delete By ID Successful");
        
    }
    

    
    
    
   
    
    

   


	
}
