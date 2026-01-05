package com.dharmaraj.jira.controllers;

import com.dharmaraj.jira.dtos.HttpResponse;
import com.dharmaraj.jira.dtos.project.CreateProjectRequestDto;
import com.dharmaraj.jira.dtos.project.CreateProjectResponseDto;
import com.dharmaraj.jira.services.interfaces.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/projects")
    public ResponseEntity<HttpResponse> createProject(@RequestBody CreateProjectRequestDto createProjectDto) {

        CreateProjectResponseDto createProjectResponseDto = projectService.createProject(createProjectDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(HttpResponse.builder().data(createProjectResponseDto).build());
    }
}
