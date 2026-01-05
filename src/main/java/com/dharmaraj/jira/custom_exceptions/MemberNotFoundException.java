package com.dharmaraj.jira.custom_exceptions;

import org.springframework.http.HttpStatus;

public class MemberNotFoundException extends BaseException {

    public MemberNotFoundException(Long memberId) {

        super("Member with id " + memberId + " not found.", HttpStatus.NOT_FOUND);
    }
}
