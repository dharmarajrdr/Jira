package com.dharmaraj.jira.services.implementations;

import com.dharmaraj.jira.dtos.project.CreateProjectRequestDto;
import com.dharmaraj.jira.dtos.project.CreateProjectResponseDto;
import com.dharmaraj.jira.models.Project;
import com.dharmaraj.jira.repositories.ProjectRepository;
import com.dharmaraj.jira.services.interfaces.MemberService;
import com.dharmaraj.jira.services.interfaces.OrgService;
import com.dharmaraj.jira.services.interfaces.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final OrgService orgService;
    private final MemberService memberService;
    private final ProjectRepository projectRepository;

    @Override
    public CreateProjectResponseDto createProject(CreateProjectRequestDto createProjectDto) {

        memberService.validateMemberPresenceInOrg(createProjectDto.getMemberId(), createProjectDto.getOrgId());

        Project project = createProjectDto.toProject();
        project.setOrg(orgService.getOrgById(createProjectDto.getOrgId()));
        project.setCreatedBy(memberService.getMemberById(createProjectDto.getMemberId()));
        projectRepository.save(project);
        return CreateProjectResponseDto.fromProject(project);
    }
}
