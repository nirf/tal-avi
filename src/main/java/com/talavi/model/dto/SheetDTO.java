package com.talavi.model.dto;

import org.springframework.hateoas.ResourceSupport;

import javax.validation.constraints.NotNull;

/**
 * Created by home on 4/24/17.
 */
public class SheetDTO  extends ResourceSupport {
    @NotNull
    private String station;

    @NotNull
    private String path;

    public SheetDTO() {
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
}
