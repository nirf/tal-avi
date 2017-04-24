package com.talavi.model.domain.list;

import com.talavi.model.domain.Sheet;

import java.util.List;

/**
 * Created by home on 4/20/17.
 */
public class SheetList {
    private List<Sheet> sheets;

    public SheetList(List<Sheet> sheets) {
        this.sheets = sheets;
    }

    public List<Sheet> getSheets() {
        return sheets;
    }

    public void setSheets(List<Sheet> sheets) {
        this.sheets = sheets;
    }
}
