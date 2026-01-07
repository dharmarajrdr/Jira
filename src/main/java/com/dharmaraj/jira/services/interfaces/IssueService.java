package com.dharmaraj.jira.services.interfaces;

import com.dharmaraj.jira.dtos.issue.CreateIssueRequestDto;
import com.dharmaraj.jira.dtos.issue.IssueResponseDto;

public interface IssueService {

    IssueResponseDto createIssue(CreateIssueRequestDto createIssueRequestDto);
}
