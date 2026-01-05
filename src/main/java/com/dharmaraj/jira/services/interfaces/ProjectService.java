package com.dharmaraj.jira.services.interfaces;

import com.dharmaraj.jira.dtos.project.CreateProjectRequestDto;
import com.dharmaraj.jira.dtos.project.CreateProjectResponseDto;

public interface ProjectService {

    CreateProjectResponseDto createProject(CreateProjectRequestDto createProjectDto);
}
