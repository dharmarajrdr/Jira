package com.dharmaraj.jira.dtos;

import lombok.Builder;

import java.util.Map;

@Builder
public class HttpResponse {

    private String message;

    private Object data;

    private Map<String, Object> info;
}
