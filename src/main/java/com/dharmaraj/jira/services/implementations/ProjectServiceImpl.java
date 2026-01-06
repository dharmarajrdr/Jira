package com.dharmaraj.jira.services.implementations;

import com.dharmaraj.jira.custom_exceptions.DataNotFoundException;
import com.dharmaraj.jira.dtos.project.AddMemberInProjectRequestDto;
import com.dharmaraj.jira.dtos.project.CreateProjectRequestDto;
import com.dharmaraj.jira.dtos.project.ProjectResponseDto;
import com.dharmaraj.jira.models.OrgMember;
import com.dharmaraj.jira.models.Project;
import com.dharmaraj.jira.models.ProjectMember;
import com.dharmaraj.jira.repositories.ProjectMemberRepository;
import com.dharmaraj.jira.repositories.ProjectRepository;
import com.dharmaraj.jira.services.interfaces.OrgMemberService;
import com.dharmaraj.jira.services.interfaces.OrgService;
import com.dharmaraj.jira.services.interfaces.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final OrgService orgService;
    private final OrgMemberService orgMemberService;
    private final ProjectRepository projectRepository;
    private final ProjectMemberRepository projectMemberRepository;

    @Override
    public ProjectResponseDto createProject(CreateProjectRequestDto createProjectDto) {

        orgMemberService.validateMemberPresenceInOrg(createProjectDto.getMemberId(), createProjectDto.getOrgId());

        Project project = createProjectDto.toProject();
        project.setOrg(orgService.getOrgById(createProjectDto.getOrgId()));
        project.setCreatedBy(orgMemberService.getMemberById(createProjectDto.getMemberId()));
        projectRepository.save(project);
        return ProjectResponseDto.fromProject(project);
    }

    @Override
    public List<ProjectResponseDto> getAllProjects(Long orgId, Long memberId) {

        orgMemberService.validateMemberPresenceInOrg(memberId, orgId);

        return projectRepository.findAllByOrg_IdOrderByName(orgId).stream().map(ProjectResponseDto::fromProject).toList();
    }

    @Override
    public void addMemberIntoProject(AddMemberInProjectRequestDto addMemberInProjectRequestDto) {

        Long projectId = addMemberInProjectRequestDto.getProjectId();
        Long orgMemberId = addMemberInProjectRequestDto.getOrgMemberId();
        Long orgMemberToAllId = addMemberInProjectRequestDto.getOrgMemberIdToAdd();

        OrgMember orgMember = orgMemberService.getMemberById(orgMemberId);
        OrgMember orgMemberToAdd = orgMemberService.getMemberById(orgMemberToAllId);

        Project project = projectRepository.findById(projectId).orElseThrow(() -> new DataNotFoundException("Project", projectId));

        ProjectMember projectMemberToAdd = new ProjectMember();
        projectMemberToAdd.setOrgMember(orgMemberToAdd);
        projectMemberToAdd.setCreatedBy(orgMember);
        projectMemberToAdd.setProject(project);
        projectMemberRepository.save(projectMemberToAdd);
    }
}
