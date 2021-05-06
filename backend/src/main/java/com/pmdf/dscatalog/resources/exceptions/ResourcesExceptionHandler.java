package com.pmdf.dscatalog.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pmdf.dscatalog.services.exceptions.DatabaseException;
import com.pmdf.dscatalog.services.exceptions.ResourceNotFoundException;

@ControllerAdvice // Anotation que irá permitir que a classe intercepte alguma exceção que
					// aconteça na camada
//de Resource (controlador Rest), para tratar a exceção
public class ResourcesExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErroPadrao> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao err = new ErroPadrao();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Recurso não encontrado");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());

		return ResponseEntity.status(status).body(err);

	}
	
	
	
	//Tratamento especial para a exceção DatabaseException	
		@ExceptionHandler(DatabaseException.class)
		public ResponseEntity<ErroPadrao> database(DatabaseException e, HttpServletRequest request) {
			HttpStatus status = HttpStatus.BAD_REQUEST;
			ErroPadrao err = new ErroPadrao();
			err.setTimestamp(Instant.now());
			err.setStatus(status.value());
			err.setError("Database exception");
			err.setMessage(e.getMessage());
			err.setPath(request.getRequestURI());
			
			return ResponseEntity.status(status).body(err);
			
			
		}
		
		// Tratamento para o erro relativo a validação de formulário 
		
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
			HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY; // código 422 do HTTP
			ValidationError err = new ValidationError();
			err.setTimestamp(Instant.now());
			err.setStatus(status.value());
			err.setError("Validation exception");
			err.setMessage(e.getMessage());
			err.setPath(request.getRequestURI());
			
			for (FieldError f : e.getBindingResult().getFieldErrors() ) {
				err.addError(f.getField(), f.getDefaultMessage());
				
			}
			
			return ResponseEntity.status(status).body(err);
			
			
		}

}
