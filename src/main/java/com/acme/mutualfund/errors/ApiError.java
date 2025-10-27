package com.acme.mutualfund.errors;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiError(
        OffsetDateTime timestamp,
        String path,
        int status,
        String error,
        String code,
        String message,
        List<Map<String, String>> fieldErrors
) {
    public static ApiError of(String path, int status, String error, String code, String message) {
        return new ApiError(OffsetDateTime.now(), path, status, error, code, message, null);
    }
    public static ApiError withFields(String path, int status, String error, String code, String message,
                                      List<Map<String, String>> fieldErrors) {
        return new ApiError(OffsetDateTime.now(), path, status, error, code, message, fieldErrors);
    }
}
