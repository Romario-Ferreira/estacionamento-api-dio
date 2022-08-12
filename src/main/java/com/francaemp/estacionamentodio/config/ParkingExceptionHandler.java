package com.francaemp.estacionamentodio.config;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.francaemp.estacionamentodio.exception.ParkingNotFoundException;

@ControllerAdvice
public class ParkingExceptionHandler{

	@ExceptionHandler(ParkingNotFoundException.class)
	public ResponseEntity<StandardError> parkingNotFound(ParkingNotFoundException e, HttpServletRequest request){
		StandardError err = new StandardError(Instant.now(), HttpStatus.NOT_FOUND.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}
