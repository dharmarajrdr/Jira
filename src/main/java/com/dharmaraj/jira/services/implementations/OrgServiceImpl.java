package com.dharmaraj.jira.services.implementations;

import com.dharmaraj.jira.models.Org;
import com.dharmaraj.jira.repositories.OrgRepository;
import com.dharmaraj.jira.services.interfaces.OrgService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrgServiceImpl implements OrgService {

    private final OrgRepository orgRepository;

    @Override
    public Org getOrgById(Long id) {

        return orgRepository.findById(id).orElseThrow();
    }
}
