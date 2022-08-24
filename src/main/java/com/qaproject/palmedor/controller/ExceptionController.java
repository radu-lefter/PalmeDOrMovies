package com.qaproject.palmedor.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.qaproject.palmedor.exceptions.NomineeNotFoundId;
import com.qaproject.palmedor.exceptions.NomineesNotFound;
import com.qaproject.palmedor.exceptions.NomineesNotFoundByGenre;
import com.qaproject.palmedor.exceptions.NomineesNotFoundByWinner;
import com.qaproject.palmedor.exceptions.NomineesNotFoundByYear;



@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(value = NomineeNotFoundId.class)
    public ResponseEntity<Object> exception(NomineeNotFoundId exception) {
       return new ResponseEntity<>("Movie Not Found. Please enter the right Id", HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(value = NomineesNotFoundByYear.class)
	   public ResponseEntity<Object> exception(NomineesNotFoundByYear exception) {
	      return new ResponseEntity<>("No movies were found for this year. Please try another year.", HttpStatus.NOT_FOUND);
	   }
	
	@ExceptionHandler(value = NomineesNotFound.class)
	   public ResponseEntity<Object> exception(NomineesNotFound exception) {
	      return new ResponseEntity<>("No movies were found. ", HttpStatus.NOT_FOUND);
	   }
	
	@ExceptionHandler(value = NomineesNotFoundByGenre.class)
	   public ResponseEntity<Object> exception(NomineesNotFoundByGenre exception) {
	      return new ResponseEntity<>("No movies were found. Try some of these genres: drama, western, thriller.", HttpStatus.NOT_FOUND);
	   }
	
	@ExceptionHandler(value = NomineesNotFoundByWinner.class)
	   public ResponseEntity<Object> exception(NomineesNotFoundByWinner exception) {
	      return new ResponseEntity<>("No movies were found for input entered. Please try 'true' or 'false'.", HttpStatus.NOT_FOUND);
	   }

}
