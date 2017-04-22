package com.talavi.service;

import com.talavi.model.domain.Project;
import com.talavi.model.domain.list.ProjectList;
import org.springframework.data.domain.Pageable;

/**
 * Created by home on 4/20/17.
 */
public interface ProjectService {
    Project create(Project project);

    Project read(Long id);

    Project update(Long id, Project project);

    Project delete(Long id);

    ProjectList getAll(Pageable pageable);

    ProjectList search(String name);

}
