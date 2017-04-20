package com.talavi.service.impl;

import com.talavi.domain.Project;
import com.talavi.domain.list.ProjectList;
import com.talavi.repository.ProjectRepository;
import com.talavi.service.ProjectService;
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
        project.setStartdate(new Date());
        Project projectCreated = projectRepository.save(project);
        return projectCreated;
    }

    @Override
    public Project read(Long id) {
        Project projectFound = projectRepository.findOne(id);
        return projectFound;
    }

    @Override
    public Project update(Long id, Project project) {
        Project projectToUpdate = read(id);
        projectToUpdate.setDescription(project.getDescription());
        projectToUpdate.setName(project.getName());
        projectToUpdate.setStartdate(new Date());
        Project projectUpdated = create(projectToUpdate);
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
