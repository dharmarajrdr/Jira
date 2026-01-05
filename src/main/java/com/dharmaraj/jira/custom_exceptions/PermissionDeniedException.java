package com.dharmaraj.jira.custom_exceptions;

import org.springframework.http.HttpStatus;

public class PermissionDeniedException extends BaseException {

    private final static HttpStatus httpStatus = HttpStatus.FORBIDDEN;

    public PermissionDeniedException(String message) {
        super(message, httpStatus);
    }
}
