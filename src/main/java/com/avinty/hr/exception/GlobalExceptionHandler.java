package com.avinty.hr.exception;

import com.avinty.hr.model.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    ResponseEntity<?> exception(Exception ex) {
        return new ResponseEntity<>(ResponseDTO.error(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
