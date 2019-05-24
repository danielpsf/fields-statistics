package com.danielpsf.labs.field.statistic.exception.handler;

import com.danielpsf.labs.field.statistic.exception.NotImplementedException;
import com.danielpsf.labs.field.statistic.exception.CustomExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class NotImplementedExceptionHandler extends CustomExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(NotImplementedExceptionHandler.class);

    @ExceptionHandler(value = {NotImplementedException.class})
    protected ResponseEntity<Object> handleNotImplemented(NotImplementedException ex, WebRequest request) {
        LOG.debug("NotImplementedExceptionHandler.handleNotImplemented: Functionality is still under development");
        return handleExceptionInternal(ex,
                getErrorResponse(ex, HttpStatus.BAD_REQUEST),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST,
                request);
    }
}
