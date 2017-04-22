package com.talavi.service.impl;

import com.talavi.model.domain.Project;
import com.talavi.model.domain.list.ProjectList;
import com.talavi.repository.ProjectRepository;
import com.talavi.service.ProjectService;
import com.talavi.service.exception.ProjectDoesNotFoundException;
import com.talavi.service.exception.ProjectExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * Created by home on 4/20/17.
 */
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project create(Project project) {
        Project projectExists = projectRepository.findByName(project.getName());
        if (projectExists != null) {
            throw new ProjectExistsException(String.format("Project with name:%s, id:%d already exists", projectExists.getName(), projectExists.getProjectId()));
        }
        Date date = new Date();
        project.setStartdate(date);
        project.setUpdatedate(date);
        Project projectCreated = projectRepository.save(project);
        return projectCreated;
    }

    @Override
    public Project read(Long id) {
        Project projectFound = projectRepository.findOne(id);
        if (projectFound == null) {
            throw new ProjectDoesNotFoundException(String.format("Project with id:%d doesn't exist", id));
        }
        return projectFound;
    }

    @Override
    public Project update(Long id, Project project) {
        Project projectToUpdate = read(id);
        projectToUpdate.setDescription(project.getDescription());
        projectToUpdate.setName(project.getName());
        projectToUpdate.setUpdatedate(new Date());
        Project projectUpdated = projectRepository.save(projectToUpdate);
        return projectUpdated;
    }

    @Override
    public Project delete(Long id) {
        Project projectToDelete = read(id);
        projectRepository.delete(projectToDelete);
        return projectToDelete;
    }

    @Override
    public ProjectList getAll(Pageable pageable) {
        return new ProjectList(projectRepository.findAll(pageable).getContent());
    }

    @Override
    public ProjectList search(String name) {
        return new ProjectList(projectRepository.findByNameContaining(name));
    }
}
