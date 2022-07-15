package com.cricket.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AllExceptionHandle  {
	
	@ExceptionHandler(PlayerNotFound.class)
	public ResponseEntity<Map<String, String>> handlePlayerException(PlayerNotFound ex)
	{
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("errorMessage ",ex.getMessage());
		return new ResponseEntity<>(errorMap,HttpStatus.NOT_FOUND);		
	}
	
	 @ExceptionHandler(NumberFormatException.class)
	    public ResponseEntity<Map<String, String>> handleBusinessException1(NumberFormatException ex) {
	        Map<String, String> errorMap = new HashMap<>();
	        errorMap.put("errorMessage", "Invalid Input");
	        return new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);
	    }

}
