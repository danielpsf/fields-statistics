package com.danielpsf.labs.field.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ErrorResponse {

    private HttpStatus status;
    private String message;
    private String error;
}