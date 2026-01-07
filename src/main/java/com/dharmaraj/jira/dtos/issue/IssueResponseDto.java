package com.dharmaraj.jira.dtos.issue;

import com.dharmaraj.jira.enums.IssueType;
import com.dharmaraj.jira.enums.Priority;
import com.dharmaraj.jira.models.Issue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IssueResponseDto {

    private Long id;

    private String title;

    private String description;

    private IssueType issueType;

    private Priority priority;

    public static IssueResponseDto fromIssue(Issue issue) {

        IssueResponseDto issueResponseDto = new IssueResponseDto();
        issueResponseDto.setId(issue.getId());
        issueResponseDto.setTitle(issue.getTitle());
        issueResponseDto.setDescription(issue.getDescription());
        issueResponseDto.setIssueType(issue.getType());
        issueResponseDto.setPriority(issue.getPriority());
        return issueResponseDto;
    }
}
