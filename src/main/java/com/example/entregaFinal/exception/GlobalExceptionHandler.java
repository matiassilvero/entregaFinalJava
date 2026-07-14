package com.example.entregaFinal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice 
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> manejarResourceNotFoundException(ResourceNotFoundException ex) {
        
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", ex.getMessage()); 
        respuesta.put("error", "Not Found");
        respuesta.put("status", "404");

        return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
    }
}