package com.talavi.model.dto.list;

import com.talavi.model.dto.SheetDTO;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by home on 4/20/17.
 */
public class SheetListDTO extends ResourceSupport {
    private List<SheetDTO> sheetDTOs;

    public SheetListDTO(List<SheetDTO> sheetDTOs) {
        this.sheetDTOs = sheetDTOs;
    }

    public List<SheetDTO> getSheetDTOs() {
        return sheetDTOs;
    }

    public void setSheetDTOs(List<SheetDTO> sheetDTOs) {
        this.sheetDTOs = sheetDTOs;
    }
}
