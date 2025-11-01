package com.acme.mutualfund.errors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            MethodArgumentNotValidException.class,
            BindException.class,
            MethodArgumentTypeMismatchException.class,
            HttpMessageNotReadableException.class
    })
    public ResponseEntity<ApiError> handleBadRequest(Exception ex, HttpServletRequest req) {
        List<Map<String, String>> fieldErrors = switch (ex) {
            case MethodArgumentNotValidException manv -> manv.getBindingResult().getFieldErrors().stream()
                    .map(fe -> {
                        assert fe.getDefaultMessage() != null;
                        return Map.of("field", fe.getField(), "message", fe.getDefaultMessage());
                    })
                    .collect(Collectors.toList());
            case BindException be -> be.getBindingResult().getFieldErrors().stream()
                    .map(fe -> {
                        assert fe.getDefaultMessage() != null;
                        return Map.of("field", fe.getField(), "message", fe.getDefaultMessage());
                    })
                    .collect(Collectors.toList());
            default -> null;
        };
        var body = ApiError.withFields(
                req.getRequestURI(), HttpStatus.BAD_REQUEST.value(), "Bad Request",
                "VALIDATION_ERROR",
                humanMessage(ex),
                fieldErrors
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiError> handleConstraintViolation(ConstraintViolationException ex, HttpServletRequest req) {
        List<Map<String, String>> fieldErrors = ex.getConstraintViolations().stream()
                .map(this::toFieldError).collect(Collectors.toList());
        var body = ApiError.withFields(
                req.getRequestURI(), HttpStatus.BAD_REQUEST.value(), "Bad Request",
                "VALIDATION_ERROR",
                "One or more parameters are invalid.",
                fieldErrors
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiError> handleAuth(AuthenticationException ex, HttpServletRequest req) {
        var body = ApiError.of(req.getRequestURI(), 401, "Unauthorized", "AUTH_REQUIRED",
                "Authentication is required to access this resource.");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(body);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiError> handleForbidden(AccessDeniedException ex, HttpServletRequest req) {
        var body = ApiError.of(req.getRequestURI(), 403, "Forbidden", "ACCESS_DENIED",
                "You don’t have permission to perform this action.");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(body);
    }

    @ExceptionHandler({NoSuchElementException.class, NotFoundException.class})
    public ResponseEntity<ApiError> handleNotFound(RuntimeException ex, HttpServletRequest req) {
        var body = ApiError.of(req.getRequestURI(), 404, "Not Found", "RESOURCE_NOT_FOUND",
                ex.getMessage() != null ? ex.getMessage() : "The requested resource was not found.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler({
            ObjectOptimisticLockingFailureException.class,
            IllegalStateException.class,
            DataIntegrityViolationException.class
    })
    public ResponseEntity<ApiError> handleConflict(RuntimeException ex, HttpServletRequest req) {
        String code = (ex instanceof ObjectOptimisticLockingFailureException)
                ? "OPTIMISTIC_LOCK_CONFLICT"
                : (ex instanceof DataIntegrityViolationException)
                ? "DATA_INTEGRITY_VIOLATION"
                : "STATE_CONFLICT";

        String msg = (ex instanceof ObjectOptimisticLockingFailureException)
                ? "The resource was modified by another request. Please retry."
                : humanMessage(ex);

        var body = ApiError.of(req.getRequestURI(), 409, "Conflict", code, msg);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ApiError> handleUnsupportedMedia(HttpMediaTypeNotSupportedException ex, HttpServletRequest req) {
        var body = ApiError.of(req.getRequestURI(), 415, "Unsupported Media Type", "UNSUPPORTED_MEDIA_TYPE",
                "Content-Type not supported. Use application/json.");
        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(body);
    }

    @ExceptionHandler({BusinessRuleException.class, IllegalArgumentException.class})
    public ResponseEntity<ApiError> handleBusiness(Exception ex, HttpServletRequest req) {
        var status = HttpStatus.UNPROCESSABLE_ENTITY;
        var body = ApiError.of(req.getRequestURI(), status.value(), status.getReasonPhrase(),
                "BUSINESS_RULE_VIOLATION",
                humanMessage(ex));
        return ResponseEntity.status(status).body(body);
    }

    @ExceptionHandler(TradingClosedException.class)
    public ResponseEntity<ApiError> handleTradingClosed(TradingClosedException ex, HttpServletRequest req) {
        var status = HttpStatus.LOCKED;
        var body = ApiError.of(req.getRequestURI(), status.value(), status.getReasonPhrase(),
                "TRADING_CLOSED",
                humanMessage(ex));
        return ResponseEntity.status(status).body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleAll(Exception ex, HttpServletRequest req) {
        var body = ApiError.of(req.getRequestURI(), 500, "Internal Server Error",
                "UNEXPECTED_ERROR",
                "Something went wrong. Please try again or contact support.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }

    private Map<String, String> toFieldError(ConstraintViolation<?> v) {
        String field = v.getPropertyPath() != null ? v.getPropertyPath().toString() : "<param>";
        return Map.of("field", field, "message", v.getMessage());
    }

    private String humanMessage(Exception ex) {
        String m = ex.getMessage();
        return (m == null || m.isBlank()) ? ex.getClass().getSimpleName() : m;
    }
}
