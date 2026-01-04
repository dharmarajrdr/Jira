package com.dharmaraj.jira.models;

import com.dharmaraj.jira.config.ModelsConfig;
import com.dharmaraj.jira.enums.IssueStatus;
import com.dharmaraj.jira.enums.IssueType;
import com.dharmaraj.jira.enums.Priority;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Issue extends OrgLevelBaseModel {

    @Column(nullable = false, length = 100)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private IssueType type;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Priority priority = ModelsConfig.DEFAULT_PRIORITY;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private IssueStatus status = ModelsConfig.DEFAULT_STATUS;
    /**
     * If no sprint is assigned, then the issue is considered to be in `Backlog`.
     */
    @ManyToOne
    private Sprint sprint;
}
