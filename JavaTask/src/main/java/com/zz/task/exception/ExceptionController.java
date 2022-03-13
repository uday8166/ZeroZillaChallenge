package com.zz.task.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
public class ExceptionController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(AgencyInvalidDetailsException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorMessage IdNotFound(AgencyInvalidDetailsException exception, WebRequest request) {
		return new ErrorMessage(HttpStatus.BAD_REQUEST.value(), new Date(), exception.getMessage(),
				request.getDescription(false));
	}

	@ExceptionHandler(ClientInvalidDetailsException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorMessage IdNotFound(ClientInvalidDetailsException exception, WebRequest request) {
		return new ErrorMessage(HttpStatus.BAD_REQUEST.value(), new Date(), exception.getMessage(),
				request.getDescription(false));

	}
}
