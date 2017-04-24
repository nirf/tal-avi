package com.talavi.controller;

import com.talavi.model.service.assembler.ProjectAssembler;
import com.talavi.model.service.assembler.ProjectListAssembler;
import com.talavi.controller.error.exception.ConflictException;
import com.talavi.controller.error.exception.NotFoundException;
import com.talavi.model.domain.Project;
import com.talavi.model.domain.list.ProjectList;
import com.talavi.model.dto.ProjectDTO;
import com.talavi.model.dto.list.ProjectListDTO;
import com.talavi.security.JwtUser;
import com.talavi.service.ProjectService;
import com.talavi.service.exception.ProjectDoesNotFoundException;
import com.talavi.service.exception.ProjectExistsException;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

/**
 * Created by home on 4/20/17.
 */
@RestController
@RequestMapping("/api")
public class ProjectController {
    private ProjectService projectService;
    private ProjectAssembler projectAssembler;
    private ProjectListAssembler projectListAssembler;

    @Autowired
    public ProjectController(ProjectService projectService, ProjectAssembler projectAssembler, ProjectListAssembler projectListAssembler) {
        this.projectService = projectService;
        this.projectAssembler = projectAssembler;
        this.projectListAssembler = projectListAssembler;
    }

    @PostMapping(value = "/project")
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO projectDTO, @AuthenticationPrincipal JwtUser user) {
        try {
            Project project = projectAssembler.getProjectMapper().projectDTOToProject(projectDTO);
            Project projectSaved = projectService.create(project);
            ProjectDTO projectDTOResource = projectAssembler.toResource(projectSaved);
            return new ResponseEntity<>(projectDTOResource, HttpStatus.CREATED);
        } catch (ProjectExistsException e) {
            throw new ConflictException(e);
        }
    }

    @GetMapping(value = "/project/{projectId}")
    public ResponseEntity<ProjectDTO> readProject(@PathVariable Long projectId) {
        try {
            Project projectFound = projectService.read(projectId);
            return new ResponseEntity<>(projectAssembler.toResource(projectFound), HttpStatus.OK);
        } catch (ProjectDoesNotFoundException e) {
            throw new NotFoundException(e);
        }

    }

    @PutMapping(value = "/project/{projectId}")
    public ResponseEntity<ProjectDTO> updateProject(@PathVariable Long projectId, @RequestBody ProjectDTO projectDTO) {
        try {
            Project project = projectAssembler.getProjectMapper().projectDTOToProject(projectDTO);
            Project projectUpdated = projectService.update(projectId, project);
            return new ResponseEntity<>(projectAssembler.toResource(projectUpdated), HttpStatus.OK);
        } catch (ProjectDoesNotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @DeleteMapping(value = "/project/{projectId}")
    public ResponseEntity<ProjectDTO> deleteProject(@PathVariable Long projectId) {
        try {
            Project projectToDelete = projectService.delete(projectId);
            return new ResponseEntity<>(projectAssembler.toResource(projectToDelete), HttpStatus.OK);
        } catch (ProjectDoesNotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @GetMapping("/project")
    public ResponseEntity<ProjectListDTO> getAllProjects(@ApiParam @PageableDefault Pageable pageable) {
        ProjectList projectList = projectService.getAll(pageable);
        return new ResponseEntity<>(projectListAssembler.toResource(projectList), HttpStatus.OK);
    }


    @GetMapping(value = "/_search/project")
    public ResponseEntity<ProjectListDTO> searchProjectByName(@RequestParam(value = "name") String name) {
        ProjectList projectList = projectService.search(name);
        return new ResponseEntity<>(projectListAssembler.toResource(projectList), HttpStatus.OK);
    }
}
