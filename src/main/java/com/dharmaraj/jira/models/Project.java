package com.dharmaraj.jira.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Project extends OrgLevelBaseModel {

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Org org;

    @OneToMany(mappedBy = "project")
    private List<Sprint> sprints;
}
