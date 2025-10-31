package com.codingSamurai.libraryMS.controllers.handlers;

import com.codingSamurai.libraryMS.dto.errors.CustomError;
import com.codingSamurai.libraryMS.dto.errors.ValidationError;
import com.codingSamurai.libraryMS.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)

    public ResponseEntity<CustomError> handleResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ValidationError> methodArgumentNotValidException (MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY; //ERRO 422
        ValidationError err = new ValidationError(Instant.now(), status.value(), "dados inválidos", request.getRequestURI());
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            err.addErrors(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ResponseEntity.status(status).body(err);

    }


}




