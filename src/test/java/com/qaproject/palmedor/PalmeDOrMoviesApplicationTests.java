package com.qaproject.palmedor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
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
    @MockBean
    private NomineesRepository nomineesRepo;
    
    @Autowired
    private MockMvc mock;
    
    
    private final Nominees TEST_MOVIE =  new Nominees(100, "Test Title 4", "", 1975, "Test Director 1", "Germany", "German", "Test plot 4",
            "test link", 57, "drama", true, Arrays.asList(new Reviews()));
    
//    @Autowired
//    private ModelMapper mapper;
    
//    @Autowired
//    private ObjectMapper obmapper;
    
    @Test
    void testCreate(){
        
        // GIVEN is our testing data - you can make this a final local variable if you want, e.g.:
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
        Assertions.assertThat(this.nomineesService.createOrUpdateMovie(TEST_MOVIE)).isEqualTo(1);
        // verify that our repo was accessed exactly once
        Mockito.verify(this.nomineesRepo, Mockito.times(1)).save(TEST_MOVIE);
        
        System.out.println("Test Successful");
        
    }

}
