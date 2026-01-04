package com.dharmaraj.jira.custom_exceptions;

import com.dharmaraj.jira.dtos.HttpResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<HttpResponse> handleBaseException(BaseException e) {
        
        return ResponseEntity.status(e.getHttpStatus()).body(e.getHttpResponse());
    }
}
