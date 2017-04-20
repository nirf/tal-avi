package com.talavi.controller;

import com.talavi.assembler.ProjectAssembler;
import com.talavi.assembler.ProjectListAssembler;
import com.talavi.domain.Project;
import com.talavi.domain.list.ProjectList;
import com.talavi.dto.ProjectDTO;
import com.talavi.dto.list.ProjectListDTO;
import com.talavi.service.ProjectService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by home on 4/20/17.
 */
@RestController
@RequestMapping("/project")
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

    @PostMapping(value = "/create")
//    @PreAuthorize("hasRole('ROLE_ADMIN')") - use later for different users
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO projectDTO) {
        Project project = projectAssembler.getProjectMapper().projectDTOToProject(projectDTO);
        Project projectSaved = projectService.create(project);
        ProjectDTO projectDTOResource = projectAssembler.toResource(projectSaved);
        return new ResponseEntity<>(projectDTOResource, HttpStatus.CREATED);
    }

    @GetMapping(value = "read/{projectId}")
    public ResponseEntity<ProjectDTO> readProject(@PathVariable Long projectId) {
        Project projectFound = projectService.read(projectId);
        return new ResponseEntity<>(projectAssembler.toResource(projectFound), HttpStatus.OK);

    }

    @PutMapping(value = "update/{projectId}")
    public ResponseEntity<ProjectDTO> updateProject(@PathVariable Long projectId, @RequestBody ProjectDTO projectDTO) {
        Project project = projectAssembler.getProjectMapper().projectDTOToProject(projectDTO);
        Project projectUpdated = projectService.update(projectId, project);
        return new ResponseEntity<>(projectAssembler.toResource(projectUpdated), HttpStatus.OK);
    }

    @DeleteMapping(value = "delete/{projectId}")
    public ResponseEntity<ProjectDTO> deleteProject(@PathVariable Long projectId) {
        Project projectToDelete = projectService.delete(projectId);
        return new ResponseEntity<>(projectAssembler.toResource(projectToDelete), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<ProjectListDTO> getAllProjects(@ApiParam Pageable pageable) {
        ProjectList projectList = projectService.getAll(pageable);
        return new ResponseEntity<>(projectListAssembler.toResource(projectList), HttpStatus.OK);
    }


    @GetMapping(value = "search")
    public ResponseEntity<ProjectListDTO> searchProjectByName(@RequestParam(value = "name") String name) {
        ProjectList projectList = projectService.search(name);
        return new ResponseEntity<>(projectListAssembler.toResource(projectList), HttpStatus.OK);
    }
}
