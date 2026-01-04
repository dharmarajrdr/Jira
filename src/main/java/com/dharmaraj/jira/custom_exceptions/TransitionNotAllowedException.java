package com.dharmaraj.jira.custom_exceptions;

import org.springframework.http.HttpStatus;

public class TransitionNotAllowedException extends BaseException {

    private static final HttpStatus HTTP_STATUS = HttpStatus.BAD_REQUEST;

    public TransitionNotAllowedException(String current, String next) {
        super("Transition from " + current + " to " + next + " is not allowed.", HTTP_STATUS);
    }
}
