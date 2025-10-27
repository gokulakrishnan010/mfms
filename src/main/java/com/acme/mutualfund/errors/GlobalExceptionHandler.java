package com.acme.mutualfund.errors;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest req){
    var err = ApiError.of("VALIDATION_ERROR", "Invalid request").at(req.getRequestURI());
    ex.getBindingResult().getFieldErrors().forEach(f -> err.addDetail(f.getField(), f.getDefaultMessage()));
    return ResponseEntity.badRequest().body(err);
  }

  @ExceptionHandler(IllegalArgumentException.class)
  ResponseEntity<ApiError> handleIllegal(IllegalArgumentException ex, HttpServletRequest req){
    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ApiError.of("BUSINESS_RULE", ex.getMessage()).at(req.getRequestURI()));
  }
}
