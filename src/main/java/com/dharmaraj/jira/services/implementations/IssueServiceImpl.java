package com.dharmaraj.jira.services.implementations;

import com.dharmaraj.jira.dtos.issue.CreateIssueRequestDto;
import com.dharmaraj.jira.dtos.issue.IssueResponseDto;
import com.dharmaraj.jira.models.Issue;
import com.dharmaraj.jira.repositories.IssueRepository;
import com.dharmaraj.jira.services.interfaces.IssueService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;

    @Override
    public IssueResponseDto createIssue(CreateIssueRequestDto createIssueRequestDto) {

        // Validation goes here...

        Issue issue = createIssueRequestDto.toIssue();
        issueRepository.save(issue);
        return IssueResponseDto.fromIssue(issue);
    }
}
