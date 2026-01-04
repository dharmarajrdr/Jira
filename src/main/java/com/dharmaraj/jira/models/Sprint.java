package com.dharmaraj.jira.models;

import com.dharmaraj.jira.enums.SprintStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Sprint extends OrgLevelBaseModel {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SprintStatus status = SprintStatus.PLANNED;

    @OneToMany(mappedBy = "sprint", fetch = FetchType.LAZY)
    private List<Issue> issues;
}
