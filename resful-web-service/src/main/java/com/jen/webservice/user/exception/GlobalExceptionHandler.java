package com.jen.webservice.user.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed",
				ex.getBindingResult().getFieldErrors().stream().map(err -> err.getDefaultMessage())
						.collect(java.util.stream.Collectors.joining(", ")));
		return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorDetails> handleException(UserNotFoundException exc){
		
		ErrorDetails error = new ErrorDetails();
		
		
		error.setDetails(exc.getMessage());
		error.setMessage("Validation Failed");
		error.setTimestamp(new Date(System.currentTimeMillis()));
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);		
	}
	
}
