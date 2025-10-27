package com.acme.mutualfund.errors;

import java.time.Instant;
import java.util.*;
import lombok.*;

@Getter @Setter @Builder
public class ApiError {
  private Instant timestamp;
  private String path;
  private String code;
  private String message;
  private Map<String,Object> details;

  public static ApiError of(String code, String message) {
    return ApiError.builder().timestamp(Instant.now()).code(code).message(message).details(new HashMap<>()).build();
  }
  public ApiError at(String path) { this.path = path; return this; }
  public ApiError addDetail(String k, Object v){ this.details.put(k,v); return this; }
}
