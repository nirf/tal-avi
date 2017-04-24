package com.talavi.model.service.assembler;

import com.talavi.controller.ProjectController;
import com.talavi.controller.SheetController;
import com.talavi.model.domain.Sheet;
import com.talavi.model.dto.SheetDTO;
import com.talavi.model.service.mapper.SheetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by home on 4/20/17.
 */
@Component
public class SheetAssembler extends ResourceAssemblerSupport<Sheet, SheetDTO> {
    @Autowired
    private SheetMapper sheetMapper;

    public SheetAssembler() {
        super(SheetController.class, SheetDTO.class);
    }

    @Override
    public SheetDTO toResource(Sheet sheet) {
        SheetDTO sheetDTO = sheetMapper.sheetToSheetDTO(sheet);
        sheetDTO.add(linkTo(methodOn(SheetController.class).readSheet(sheet.getSheetId())).withSelfRel());
        sheetDTO.add(linkTo(methodOn(ProjectController.class).readProject(sheet.getProject().getProjectId())).withRel("owner"));
        return sheetDTO;
    }

    public SheetMapper getSheetMapper() {
        return sheetMapper;
    }
}
