package com.talavi.dto;

import org.springframework.hateoas.ResourceSupport;

import java.util.Date;

/**
 * Created by home on 4/20/17.
 */
//@Data
public class ProjectDTO extends ResourceSupport{

    private String name;

    private Date startdate;

    private String description;

    public ProjectDTO() {
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
