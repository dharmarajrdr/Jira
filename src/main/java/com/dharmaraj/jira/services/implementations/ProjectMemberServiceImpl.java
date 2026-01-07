package com.dharmaraj.jira.services.implementations;

import com.dharmaraj.jira.custom_exceptions.MemberNotFoundException;
import com.dharmaraj.jira.models.ProjectMember;
import com.dharmaraj.jira.repositories.ProjectMemberRepository;
import com.dharmaraj.jira.services.interfaces.ProjectMemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService {

    private final ProjectMemberRepository projectMemberRepository;

    @Override
    public ProjectMember getProjectMemberByOrgMemberId(Long id) {

        return projectMemberRepository.findByOrgMember_Id(id).orElseThrow(() -> new MemberNotFoundException(id));
    }
}
