package com.dharmaraj.jira.services.implementations;

import com.dharmaraj.jira.dtos.project.CreateProjectRequestDto;
import com.dharmaraj.jira.dtos.project.ProjectResponseDto;
import com.dharmaraj.jira.models.Project;
import com.dharmaraj.jira.repositories.ProjectRepository;
import com.dharmaraj.jira.services.interfaces.MemberService;
import com.dharmaraj.jira.services.interfaces.OrgService;
import com.dharmaraj.jira.services.interfaces.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final OrgService orgService;
    private final MemberService memberService;
    private final ProjectRepository projectRepository;

    @Override
    public ProjectResponseDto createProject(CreateProjectRequestDto createProjectDto) {

        memberService.validateMemberPresenceInOrg(createProjectDto.getMemberId(), createProjectDto.getOrgId());

        Project project = createProjectDto.toProject();
        project.setOrg(orgService.getOrgById(createProjectDto.getOrgId()));
        project.setCreatedBy(memberService.getMemberById(createProjectDto.getMemberId()));
        projectRepository.save(project);
        return ProjectResponseDto.fromProject(project);
    }

    @Override
    public List<ProjectResponseDto> getAllProjects(Long orgId, Long memberId) {

        memberService.validateMemberPresenceInOrg(memberId, orgId);

        return projectRepository.findAllByOrg_IdOrderByName(orgId).stream().map(ProjectResponseDto::fromProject).toList();
    }
}
