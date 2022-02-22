package com.example.bancopan.validations.erros;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Error.class)
    protected ResponseEntity<Object> handleCustomError(final Error error, final WebRequest request) {
        return new ResponseEntity<Object>(error, new HttpHeaders(), HttpStatus.valueOf(error.getStatus()));
    }

}
