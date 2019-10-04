package com.stackroute.movieapp.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(HttpServletRequest request, Exception ex){
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<?> handleAlreadyExistsException(HttpServletRequest request, Exception ex) {
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}
