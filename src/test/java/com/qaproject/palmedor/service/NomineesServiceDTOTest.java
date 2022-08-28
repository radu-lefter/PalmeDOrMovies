package com.qaproject.palmedor.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.qaproject.palmedor.controller.NomineesController;
import com.qaproject.palmedor.controller.NomineesControllerDTO;
import com.qaproject.palmedor.model.Nominees;
import com.qaproject.palmedor.model.Reviews;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class NomineesServiceDTOTest {

	 @InjectMocks
	    private NomineesControllerDTO nomineeControllerDTO;

	    @Mock
	    private NomineesServiceDTO nomineeServiceMockDTO;
	    
	    final String greeet = "Welcome to Palme D'Or Movies. Enjoy our selection of the best movies.";
	    
	    final Nominees TEST_MOVIE = new Nominees(1001, "Test Title 4", "", 1975, "Test Director 1", "Germany", "German", "Test plot 4",
	            "test link", 57, "drama", true, Arrays.asList(new Reviews()));

	    @BeforeEach
	    void setUp() {
	        List<Nominees> nomineesList = List.of((TEST_MOVIE));
	        
	        BDDMockito.when(nomineeServiceMockDTO.getAllMovies())
	                .thenReturn(nomineesList);
	        

	        System.out.println(nomineesList);
	    }

	    @Test
	    @DisplayName("List of nominees DTO")
	    void list_ReturnListOfNominees() {
	        String expectedName = "Test Title 4";

	        List<Nominees> nomineesList = nomineeControllerDTO.getAllMovies();

	        Assertions.assertThat(nomineesList)
	                .isNotNull()
	                .isNotEmpty()
	                .hasSize(1);

	        Assertions.assertThat(nomineesList.get(0).getTitle()).isEqualTo(expectedName);
	        
	        System.out.println(nomineesList.get(0).getTitle());
	    }
	    


}
