package com.edu.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	       String error = "Malformed JSON request";
	       return buildResponseEntity(new CustomResponse(error,HttpStatus.BAD_REQUEST));
	   }
	
	
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
		   String error = "Media Type Not Supported";
	       return buildResponseEntity(new CustomResponse(error,HttpStatus.UNSUPPORTED_MEDIA_TYPE));
	}
	
	protected ResponseEntity<Object> handleAsyncRequestTimeoutException(AsyncRequestTimeoutException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
		 String error = "Service Not Available";
		 return buildResponseEntity(new CustomResponse(error,HttpStatus.SERVICE_UNAVAILABLE));
	}

	protected ResponseEntity<Object> handleUnauthorizeUser(){
		String error="Unauthorize User";
		 return buildResponseEntity(new CustomResponse(error,HttpStatus.UNAUTHORIZED));
	}
	   
	private ResponseEntity<Object> buildResponseEntity(CustomResponse apiError) {
	       return new ResponseEntity<>(apiError, apiError.getStatus());
	}
	
	
}
