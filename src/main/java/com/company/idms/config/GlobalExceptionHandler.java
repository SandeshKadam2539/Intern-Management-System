package com.company.idms.config;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
@ExceptionHandler(IllegalArgumentException.class)
public ResponseEntity<?> handleIllegalArg(IllegalArgumentException ex)
{
 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", ex.getMessage()));
}
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<?> handleValidation(MethodArgumentNotValidException ex)
{
 var first = ex.getBindingResult().getFieldErrors().stream().findFirst().map(e->e.getDefaultMessage()).orElse("Validation error");
 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", first));
}
}

