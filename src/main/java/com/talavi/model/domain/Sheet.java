package com.talavi.model.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * Created by home on 4/24/17.
 */
@Entity
@Table(name = "sheet")
public class Sheet {
    @Id
    @GeneratedValue
    private Long sheetId;

    private String station;

    private String path;

    @ManyToOne
    private Project project;

//
//    @OneToMany(mappedBy = "sheet")
//    @JsonIgnore
//    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//    private Set<SheetEvent> sheetEvents = new HashSet<>();


    public Sheet() {
    }

    public Long getSheetId() {
        return sheetId;
    }

    public void setSheetId(Long sheetId) {
        this.sheetId = sheetId;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
