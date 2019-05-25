package com.danielpsf.labs.field.statistic.exception;

import com.danielpsf.labs.field.statistic.domain.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public abstract class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    protected ErrorResponse getErrorResponse(RuntimeException ex, HttpStatus status) {
        return ErrorResponse.builder()
                .status(status)
                .message(ex.getMessage())
                .error(ex.getClass().getSimpleName())
                .build();
    }
}
