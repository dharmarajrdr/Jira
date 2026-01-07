package com.dharmaraj.jira.models;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class ProjectLevelBaseModel extends BaseModel {

    @ManyToOne
    private ProjectMember projectMember;
}
