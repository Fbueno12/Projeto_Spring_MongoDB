package com.felipebueno.workshopmongodb.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.felipebueno.workshopmongodb.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundException e, HttpServletRequest req){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandarError err = new StandarError(System.currentTimeMillis(), 
				status.value(),
				"Objeto não encontrado",
				e.getMessage(),
				req.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
}
