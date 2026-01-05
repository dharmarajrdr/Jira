package com.dharmaraj.jira.dtos.project;

import com.dharmaraj.jira.models.Project;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProjectRequestDto {

    private String name;

    private Long orgId;

    private Long memberId;

    public Project toProject() {

        Project project = new Project();
        project.setName(name);
        return project;
    }
}
