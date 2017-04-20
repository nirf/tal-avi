package com.talavi.domain.list;

import com.talavi.domain.Project;

import java.util.List;

/**
 * Created by home on 4/20/17.
 */
public class ProjectList {
    private List<Project> projects;

    public ProjectList(List<Project> projects) {
        this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
