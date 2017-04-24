package com.talavi.model.service.mapper;

import com.talavi.model.domain.Project;
import com.talavi.model.dto.ProjectDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by home on 4/20/17.
 */
@Mapper(componentModel = "spring")
@Component
public interface ProjectMapper {
    ProjectDTO projectToProjectDTO(Project project);

    List<ProjectDTO> projectsToProjectDTOs(List<Project> projects);

    Project projectDTOToProject(ProjectDTO projectDTO);

    List<Project> projectDTOsToProjects(List<ProjectDTO> projectDTOs);

}




