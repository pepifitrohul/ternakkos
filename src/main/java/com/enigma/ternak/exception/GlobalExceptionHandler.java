package com.enigma.ternak.exception;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<CustomErrorResponse> notFoundException(NotFoundException e, WebRequest request) {
		CustomErrorResponse error = new CustomErrorResponse();
		String path = ((ServletWebRequest) request).getRequest().getRequestURI().toString();
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setPath(path);

		return new ResponseEntity<CustomErrorResponse>(error, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("status", status.value());

		// Get all errors
		List<String> message = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		body.put("message", message);

		return new ResponseEntity<>(body, headers, status);

	}

	@ExceptionHandler(BadRequest.class)
	public ResponseEntity<CustomErrorResponse> badRequest(BadRequest e, WebRequest request) {
		CustomErrorResponse error = new CustomErrorResponse();
		String path = ((ServletWebRequest) request).getRequest().getRequestURI().toString();
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setPath(path);

		return new ResponseEntity<CustomErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(StatusOk.class)
	public ResponseEntity<CustomErrorResponse> badRequest(StatusOk e, WebRequest request) {
		CustomErrorResponse error = new CustomErrorResponse();
		String path = ((ServletWebRequest) request).getRequest().getRequestURI().toString();
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.OK.value());
		error.setMessage(e.getMessage());
		error.setPath(path);

		return new ResponseEntity<CustomErrorResponse>(error, HttpStatus.OK);
	}

}
