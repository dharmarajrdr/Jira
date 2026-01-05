package com.dharmaraj.jira.services.interfaces;

import com.dharmaraj.jira.dtos.project.CreateProjectRequestDto;
import com.dharmaraj.jira.dtos.project.ProjectResponseDto;

import java.util.List;

public interface ProjectService {

    ProjectResponseDto createProject(CreateProjectRequestDto createProjectDto);

    List<ProjectResponseDto> getAllProjects(Long orgId, Long memberId);
}
