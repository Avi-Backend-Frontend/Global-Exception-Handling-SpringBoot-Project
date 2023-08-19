package com.example.demo.handing;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.BalanceNotFoundException;

@ControllerAdvice
public class ExceptionHandling {

	@ExceptionHandler(value = BalanceNotFoundException.class)
	public ResponseEntity<Object> handler(BalanceNotFoundException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.ACCEPTED);
	}

}
