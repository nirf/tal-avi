package com.talavi.repository;

import com.talavi.model.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by home on 4/20/17.
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByNameContaining(String name);

    Project findByName(String name);
}
