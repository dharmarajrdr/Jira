package com.dharmaraj.jira.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public enum IssueStatus {

    OPEN {
        @Override
        public List<IssueStatus> nextValidStates() {
            return List.of(IN_PROGRESS);
        }
    },
    IN_PROGRESS {
        @Override
        public List<IssueStatus> nextValidStates() {
            return List.of(IN_REVIEW, OPEN);
        }
    },
    IN_REVIEW {
        @Override
        public List<IssueStatus> nextValidStates() {
            return List.of(DONE, IN_PROGRESS);
        }
    },
    DONE {
        @Override
        public List<IssueStatus> nextValidStates() {
            return List.of(IN_PROGRESS); // Re-open if bug found
        }
    };

    public abstract List<IssueStatus> nextValidStates();
}