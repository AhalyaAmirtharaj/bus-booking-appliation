package com.bus.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//This catches all errors and returns clean JSON messages
@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(RuntimeException.class)
public ResponseEntity<Map<String, String>> handleError(RuntimeException ex) {
Map<String, String> error = new HashMap<>();
error.put("message", ex.getMessage());
return ResponseEntity.badRequest().body(error);
}
}