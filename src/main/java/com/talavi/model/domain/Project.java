package com.talavi.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by home on 4/20/17.
 */
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue
    private Long projectId;

    private String name;

    private Date startdate;

    private Date updatedate;

    private String description;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private Set<Sheet> sheets = new HashSet<>();

    public Project() {
    }

    public Project(Long projectId) {
        this.projectId = projectId;
    }


    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
