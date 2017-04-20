package com.talavi.assembler;

import com.talavi.controller.ProjectController;
import com.talavi.domain.list.ProjectList;
import com.talavi.dto.ProjectDTO;
import com.talavi.dto.list.ProjectListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by home on 4/20/17.
 */
@Component
public class ProjectListAssembler extends ResourceAssemblerSupport<ProjectList, ProjectListDTO> {

    @Autowired
    private ProjectAssembler projectAssembler;

    public ProjectListAssembler() {
        super(ProjectController.class, ProjectListDTO.class);
    }

    @Override
    public ProjectListDTO toResource(ProjectList projectList) {
        List<ProjectDTO> projectDTOS = projectAssembler.toResources(projectList.getProjects());
        ProjectListDTO projectListDTO = new ProjectListDTO(projectDTOS);
        return projectListDTO;
    }
}
