package com.dharmaraj.jira.custom_exceptions;

import org.springframework.http.HttpStatus;

public class DataNotFoundException extends BaseException {

    public DataNotFoundException(String entity, Long id) {
        super(entity + " with ID " + id + " does not exist.", HttpStatus.NOT_FOUND);
    }
}
