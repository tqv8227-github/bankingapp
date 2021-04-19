package com.banking.errorhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ExceptionHelper {

	public ExceptionHelper() {
		log.info("ExceptionHander in constructor");
	}
	/////////////////////////////////////////////////////////////////////////////////////
	 @ExceptionHandler(value = {Exception.class })
	 public ResponseEntity<Object> handleException(Exception ex) {
	     log.error("ExceptionHandler-Exception:",ex.getMessage());
	     return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	 }
	 //////////////////////////////////////////////////////////////////////////////////
	 @ExceptionHandler(value= {NameNotFoundException.class})
	 public ResponseEntity<Object> handleNameNotFoundException(NameNotFoundException ex) {
	     log.error("NameNotFoundException:",ex.getMessage());
	     return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	 }
}
