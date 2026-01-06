package com.dharmaraj.jira.controllers;

import com.dharmaraj.jira.dtos.HttpResponse;
import com.dharmaraj.jira.dtos.project.AddMemberInProjectRequestDto;
import com.dharmaraj.jira.dtos.project.CreateProjectRequestDto;
import com.dharmaraj.jira.dtos.project.ProjectResponseDto;
import com.dharmaraj.jira.services.interfaces.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/projects")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/")
    public ResponseEntity<HttpResponse> createProject(@RequestBody CreateProjectRequestDto createProjectDto) {

        ProjectResponseDto createProjectResponseDto = projectService.createProject(createProjectDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(HttpResponse.builder().message("Project created successfully.").data(createProjectResponseDto).build());
    }

    @GetMapping("/")
    public ResponseEntity<HttpResponse> getAllProjects(@RequestParam(required = false) Long orgId, @RequestParam(required = false) Long memberId) {

        List<ProjectResponseDto> projects = projectService.getAllProjects(orgId, memberId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(HttpResponse.builder().message("Projects retrieved successfully.").data(projects).build());
    }

    @PostMapping("/member")
    public ResponseEntity<HttpResponse> addMember(@RequestBody AddMemberInProjectRequestDto addMemberInProjectRequestDto) {

        projectService.addMemberIntoProject(addMemberInProjectRequestDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(HttpResponse.builder().message("Member added into the project successfully.").build());
    }
}
