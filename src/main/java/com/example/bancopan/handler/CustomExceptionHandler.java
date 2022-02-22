package com.example.bancopan.handler;

import com.example.bancopan.exceptions.*;
import com.example.bancopan.handler.custom.EntityErrorResponse;
import com.example.bancopan.handler.custom.StandardError;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomExceptionHandler {

    /**
     * Captura execeções lançadas e exibe de forma mais clara
     *
     * @param exception exceção lançada
     * @return response contendo uma exibição mais clara e os erros da requestt
     */
    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<EntityErrorResponse> handleResourceNotFoundException (ClientNotFoundException exception){
        List<StandardError> errors = new ArrayList<>();
        errors.add(new StandardError(exception.getLocalizedMessage()));
        EntityErrorResponse response = new EntityErrorResponse(
                exception.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                errors);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<EntityErrorResponse> handleResourceNotFoundException (AddressNotFoundException exception){
        List<StandardError> errors = new ArrayList<>();
        errors.add(new StandardError(exception.getLocalizedMessage()));
        EntityErrorResponse response = new EntityErrorResponse(
                exception.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                errors);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(CPFNotValidException.class)
    public ResponseEntity<EntityErrorResponse> handleResourceNotFoundException (CPFNotValidException exception){
        List<StandardError> errors = new ArrayList<>();
        errors.add(new StandardError(exception.getLocalizedMessage()));
        EntityErrorResponse response = new EntityErrorResponse(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(InvalidZipCodeException.class)
    public ResponseEntity<EntityErrorResponse> handleResourceNotFoundException (InvalidZipCodeException exception){
        List<StandardError> errors = new ArrayList<>();
        errors.add(new StandardError(exception.getLocalizedMessage()));
        EntityErrorResponse response = new EntityErrorResponse(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(StateNotFoundException.class)
    public ResponseEntity<EntityErrorResponse> handleResourceNotFoundException (StateNotFoundException exception){
        List<StandardError> errors = new ArrayList<>();
        errors.add(new StandardError(exception.getLocalizedMessage()));
        EntityErrorResponse response = new EntityErrorResponse(
                exception.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                errors);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }


}

