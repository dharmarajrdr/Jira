package com.dharmaraj.jira.custom_exceptions;

import com.dharmaraj.jira.dtos.HttpResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
class BaseException extends RuntimeException {

    private final String message;

    private final HttpStatus httpStatus;

    public BaseException(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public HttpResponse getHttpResponse() {

        return HttpResponse.builder().message(this.message).build();
    }
}
