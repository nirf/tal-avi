package com.talavi.service;

import com.talavi.domain.Project;
import com.talavi.domain.list.ProjectList;
import org.springframework.data.domain.Pageable;

import java.util.List;

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
