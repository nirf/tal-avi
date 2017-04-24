package com.talavi.model.service.assembler;

import com.talavi.controller.SheetController;
import com.talavi.model.domain.list.SheetList;
import com.talavi.model.dto.SheetDTO;
import com.talavi.model.dto.list.SheetListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by home on 4/20/17.
 */
@Component
public class SheetListAssembler extends ResourceAssemblerSupport<SheetList, SheetListDTO> {

    @Autowired
    private SheetAssembler sheetAssembler;

    public SheetListAssembler() {
        super(SheetController.class, SheetListDTO.class);
    }

    @Override
    public SheetListDTO toResource(SheetList sheetList) {
        List<SheetDTO> sheetDTOS = sheetAssembler.toResources(sheetList.getSheets());
        SheetListDTO sheetListDTO = new SheetListDTO(sheetDTOS);
        return sheetListDTO;
    }
}
