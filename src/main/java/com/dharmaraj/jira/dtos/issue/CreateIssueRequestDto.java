package com.dharmaraj.jira.dtos.issue;

import com.dharmaraj.jira.enums.IssueType;
import com.dharmaraj.jira.enums.Priority;
import com.dharmaraj.jira.models.Issue;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateIssueRequestDto {

    private String title;

    private String description;

    private IssueType issueType;

    private Priority priority;

    public Issue toIssue() {
        Issue issue = new Issue();
        issue.setTitle(title);
        issue.setDescription(description);
        issue.setType(issueType);
        issue.setPriority(priority);
        return issue;
    }
}
