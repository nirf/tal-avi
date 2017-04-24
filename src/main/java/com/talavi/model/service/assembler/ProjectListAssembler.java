package com.talavi.model.service.assembler;

import com.talavi.controller.ProjectController;
import com.talavi.model.domain.list.ProjectList;
import com.talavi.model.dto.ProjectDTO;
import com.talavi.model.dto.list.ProjectListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by home on 4/20/17.
 */
@Component
public class ProjectListAssembler extends ResourceAssemblerSupport<ProjectList, ProjectListDTO> {

    @Autowired
    private ProjectAssembler projectAssembler;

//    @Autowired
//    private PagedResourcesAssembler<ProjectDTO> projectDTOPagedResourcesAssembler;

    public ProjectListAssembler() {
        super(ProjectController.class, ProjectListDTO.class);
    }

    @Override
    public ProjectListDTO toResource(ProjectList projectList) {
        List<ProjectDTO> projectDTOS = projectAssembler.toResources(projectList.getProjects());
        ProjectListDTO projectListDTO = new ProjectListDTO(projectDTOS);
        Link projectsLink = linkTo(methodOn(ProjectController.class).getAllProjects(null)).withRel("projects");
//        projectDTOPagedResourcesAssembler.
//        projectListDTO.add(projectDTOPagedResourcesAssembler.appendPaginationParameterTemplates(projectsLink));
        return projectListDTO;
    }
}
