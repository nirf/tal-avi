package com.talavi.model.dto.list;

import com.talavi.model.dto.ProjectDTO;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by home on 4/20/17.
 */
public class ProjectListDTO extends ResourceSupport {
    private List<ProjectDTO> projectDTOs;

    public ProjectListDTO(List<ProjectDTO> projectDTOs) {
        this.projectDTOs = projectDTOs;
    }

    public List<ProjectDTO> getProjectDTOs() {
        return projectDTOs;
    }

    public void setProjectDTOs(List<ProjectDTO> projectDTOs) {
        this.projectDTOs = projectDTOs;
    }
}
