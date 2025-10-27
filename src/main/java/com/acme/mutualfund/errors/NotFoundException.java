package com.acme.mutualfund.errors;

/**
 * Exception thrown when a requested resource is not found.
 * Maps to HTTP 404 via GlobalExceptionHandler.
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) { super(message); }
}