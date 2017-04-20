package com.talavi.assembler;

import com.talavi.controller.ProjectController;
import com.talavi.domain.Project;
import com.talavi.dto.ProjectDTO;
import com.talavi.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by home on 4/20/17.
 */
@Component
public class ProjectAssembler extends ResourceAssemblerSupport<Project, ProjectDTO> {
    @Autowired
    private ProjectMapper projectMapper;

    public ProjectAssembler() {
        super(ProjectController.class, ProjectDTO.class);
    }

    @Override
    public ProjectDTO toResource(Project project) {
        ProjectDTO projectDTO = projectMapper.projectToProjectDTO(project);
        projectDTO.add(linkTo(methodOn(ProjectController.class).readProject(project.getProjectId())).withSelfRel());
        return projectDTO;
    }

    public ProjectMapper getProjectMapper() {
        return projectMapper;
    }
}
