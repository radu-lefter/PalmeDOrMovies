package com.qaproject.palmedor.controller;

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
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.qaproject.palmedor.model.Nominees;
import com.qaproject.palmedor.model.Reviews;
import com.qaproject.palmedor.service.NomineesService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class NomineesControllerTest {
    @InjectMocks
    private NomineesController nomineeController;

    @Mock
    private NomineesService nomineeServiceMock;
    
    final String greeet = "Welcome to Palme D'Or Movies. Enjoy our selection of the best movies.";
    
    final Nominees TEST_MOVIE = new Nominees(1001, "Test Title 4", "", 1975, "Test Director 1", "Germany", "German", "Test plot 4",
            "test link", 57, "drama", true, Arrays.asList(new Reviews()));

    @BeforeEach
    void setUp() {
        List<Nominees> nomineesList = List.of((TEST_MOVIE));
        BDDMockito.when(nomineeServiceMock.getAllMovies())
                .thenReturn(nomineesList);
        
        BDDMockito.when(nomineeServiceMock.getMovieById(1001))
        .thenReturn(TEST_MOVIE);
        
        BDDMockito.when(nomineeServiceMock.getMoviesByYear(1975))
        .thenReturn(nomineesList);
        
        BDDMockito.when(nomineeServiceMock.getMoviesByGenre("drama"))
        .thenReturn(nomineesList);
        
        BDDMockito.when(nomineeServiceMock.getMoviesAfterYear(1970))
        .thenReturn(nomineesList);
        
        BDDMockito.when(nomineeServiceMock.getMoviesByWinner(true))
        .thenReturn(nomineesList);
        
        BDDMockito.when(nomineeServiceMock.createOrUpdateMovie(TEST_MOVIE))
        .thenReturn(TEST_MOVIE);
        
        BDDMockito.when(nomineeServiceMock.updateTitle("Test Title 4", 1001))
        .thenReturn(TEST_MOVIE);
        
        
        System.out.println(nomineesList);
    }

    @Test
    @DisplayName("Nominee by ID")
    void NomineeByID() {
        String expectedName = "Test Title 4";

        Nominees nominee = nomineeController.getMovieById(1001);

        Assertions.assertThat(nominee)
                .isNotNull();

        Assertions.assertThat(nominee.getTitle()).isEqualTo(expectedName);
        
        System.out.println(nominee.getTitle());
    }
    
    @Test
    @DisplayName("Nominee by ID App")
    void NomineeByIDApp() {

        ModelAndView nominee = nomineeController.getMovieByIdApp(1001);

        Assertions.assertThat(nominee)
                .isNotNull();

    }
    
    @Test
    @DisplayName("Nominee by ID App")
    void TestGreeting() {

        String message = nomineeController.greeting();

        Assertions.assertThat(message)
                .isNotNull()
                .isEqualTo("Welcome to Palme D'Or Movies. Enjoy our selection of the best movies.");

    }
    
    
    @Test
    @DisplayName("List of nominees")
    void list_ReturnListOfNominees() {
        String expectedName = "Test Title 4";

        List<Nominees> nomineesList = nomineeController.getAllMovies();

        Assertions.assertThat(nomineesList)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(nomineesList.get(0).getTitle()).isEqualTo(expectedName);
        
        System.out.println(nomineesList.get(0).getTitle());
    }
    
    @Test
    @DisplayName("List of nominees App")
    void list_ReturnListOfNomineesApp() {
    	ModelAndView nominee = nomineeController.allMovies();

        Assertions.assertThat(nominee)
                .isNotNull();
    }
    
    @Test
    @DisplayName("Nominee by Year")
    void NomineeByYear() {
        String expectedName = "Test Title 4";

        List<Nominees> nomineesList = nomineeController.getMovieByYear(1975);

        Assertions.assertThat(nomineesList)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(nomineesList.get(0).getTitle()).isEqualTo(expectedName);
        
        System.out.println(nomineesList.get(0).getTitle());
    }
    
    @Test
    @DisplayName("Nominee by Genre")
    void NomineeByGenre() {
        String expectedGenre = "drama";

        List<Nominees> nomineesList = nomineeController.getMoviesByGenre("drama");

        Assertions.assertThat(nomineesList)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(nomineesList.get(0).getGenre()).isEqualTo(expectedGenre);
        
        System.out.println(nomineesList.get(0).getGenre());
    }
    
    @Test
    @DisplayName("Nominee After year")
    void NomineeAfterYear() {
        String expectedName = "Test Title 4";

        List<Nominees> nomineesList = nomineeController.getMoviesAfterYear(1970);

        Assertions.assertThat(nomineesList)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(nomineesList.get(0).getTitle()).isEqualTo(expectedName);
        
        System.out.println(nomineesList.get(0).getTitle());
    }
    
    @Test
    @DisplayName("Nominee By Winner")
    void NomineeByWinner() {
        String expectedName = "Test Title 4";

        List<Nominees> nomineesList = nomineeController.getMoviesByWinners("true");

        Assertions.assertThat(nomineesList)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(nomineesList.get(0).getTitle()).isEqualTo(expectedName);
        
        System.out.println(nomineesList.get(0).getTitle());
    }
    
    @Test
    @DisplayName("Create Nominee")
    void CreateNominee() {
    	String expectedName = "Test Title 4";

        Nominees nominee = nomineeController.saveMovie(TEST_MOVIE);

        Assertions.assertThat(nominee)
                .isNotNull();

        Assertions.assertThat(nominee.getTitle()).isEqualTo(expectedName);
        
        System.out.println(nominee.getTitle());
    }
    
    
    @Test
    @DisplayName("Create Nominee Form App")
    void CreateNomineesApp() {
    	ModelAndView nominee = nomineeController.saveMovieApp();

        Assertions.assertThat(nominee)
                .isNotNull();
    }
    
    @Test
    @DisplayName("Update Nominee")
    void UpdateNominee() {
    	String expectedName = "Test Title 4";

        Nominees nominee = nomineeController.update(TEST_MOVIE);

        Assertions.assertThat(nominee)
                .isNotNull();

        Assertions.assertThat(nominee.getTitle()).isEqualTo(expectedName);
        
        System.out.println(nominee.getTitle());
    }
    
    @Test
    @DisplayName("Update Nominee")
    void UpdateNomineeTitle() {

        Nominees nominee = nomineeController.updateTitle("Test Title 4", 1001);

        Assertions.assertThat(nominee)
                .isNotNull();

        Assertions.assertThat(nominee.getId()).isEqualTo(1001);
        
        System.out.println(nominee.getTitle());
    }
    
    @Test
    @DisplayName("Update Nominee")
    void DeleteNomineeTitle() {

        int result = nomineeController.deleteMovie(1001);

        Assertions.assertThat(result)
                .isNotNull()
                .isEqualTo(0);
        
    }
    
    
    
    
    
     
       
}
