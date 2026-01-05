package com.dharmaraj.jira.dtos.project;

import com.dharmaraj.jira.models.Project;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProjectResponseDto {

    private Long projectId;

    private String name;

    public static CreateProjectResponseDto fromProject(Project project) {

        CreateProjectResponseDto createProjectResponseDto = new CreateProjectResponseDto();
        createProjectResponseDto.setProjectId(project.getId());
        createProjectResponseDto.setName(project.getName());
        return createProjectResponseDto;
    }
}
