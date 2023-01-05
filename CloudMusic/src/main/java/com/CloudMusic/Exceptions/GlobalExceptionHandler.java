package com.CloudMusic.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorDetails> myExceptionHandler(UserException pe , WebRequest req)
	{
		ErrorDetails err  = new ErrorDetails();
		err.setDescription(req.getDescription(false));
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(pe.getMessage());
		
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	@ExceptionHandler(SongException.class)
	public ResponseEntity<ErrorDetails> myExceptionHandler(SongException pe , WebRequest req)
	{
		ErrorDetails err  = new ErrorDetails();
		err.setDescription(req.getDescription(false));
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(pe.getMessage());
		
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> myExceptionHandler(MethodArgumentNotValidException pe)
	{
		ErrorDetails err  = new ErrorDetails();
		err.setDescription("getting Error");
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(pe.getFieldError().getDefaultMessage());
		
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	
}
