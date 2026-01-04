package com.dharmaraj.jira.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IssueStatus {

    OPEN(1), IN_PROGRESS(2), IN_REVIEW(3), CLOSED(4);

    private final int level;
}
