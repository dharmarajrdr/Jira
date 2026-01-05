package com.dharmaraj.jira.dtos.project;

import com.dharmaraj.jira.models.Project;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectResponseDto {

    private Long projectId;

    private String name;

    public static ProjectResponseDto fromProject(Project project) {

        ProjectResponseDto createProjectResponseDto = new ProjectResponseDto();
        createProjectResponseDto.setProjectId(project.getId());
        createProjectResponseDto.setName(project.getName());
        return createProjectResponseDto;
    }
}
