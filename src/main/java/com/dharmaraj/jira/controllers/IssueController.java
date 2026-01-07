package com.dharmaraj.jira.controllers;

import com.dharmaraj.jira.dtos.HttpResponse;
import com.dharmaraj.jira.dtos.issue.CreateIssueRequestDto;
import com.dharmaraj.jira.dtos.issue.IssueResponseDto;
import com.dharmaraj.jira.services.interfaces.IssueService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/issue")
public class IssueController {

    private final IssueService issueService;

    @PostMapping("/")
    public ResponseEntity<HttpResponse> createIssue(@RequestBody CreateIssueRequestDto createIssueRequestDto) {

        IssueResponseDto createIssueResponseDto = issueService.createIssue(createIssueRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(HttpResponse.builder().message("Issue created successfully.").data(createIssueResponseDto).build());
    }
}
