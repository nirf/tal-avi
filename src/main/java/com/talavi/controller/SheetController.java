package com.talavi.controller;

import com.talavi.model.domain.Sheet;
import com.talavi.model.domain.list.SheetList;
import com.talavi.model.dto.SheetDTO;
import com.talavi.model.dto.list.SheetListDTO;
import com.talavi.model.service.assembler.SheetAssembler;
import com.talavi.model.service.assembler.SheetListAssembler;
import com.talavi.service.SheetService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by home on 4/20/17.
 */
@RestController
@RequestMapping("/api")
public class SheetController {
    private SheetService sheetService;
    private SheetAssembler sheetAssembler;
    private SheetListAssembler sheetListAssembler;

    @Autowired
    public SheetController(SheetService sheetService, SheetAssembler sheetAssembler, SheetListAssembler sheetListAssembler) {
        this.sheetService = sheetService;
        this.sheetAssembler = sheetAssembler;
        this.sheetListAssembler = sheetListAssembler;
    }

    @PostMapping(value = "/project/{projectId}/sheet")
    public ResponseEntity<SheetDTO> createSheet(@Valid @RequestBody SheetDTO sheetDTO, @PathVariable Long projectId) {
        Sheet sheet = sheetAssembler.getSheetMapper().sheetDTOToSheet(sheetDTO);
        Sheet sheetSaved = sheetService.create(sheet, projectId);
        SheetDTO sheetDTOResource = sheetAssembler.toResource(sheetSaved);
        return new ResponseEntity<>(sheetDTOResource, HttpStatus.CREATED);

    }

    @GetMapping(value = "/sheet/{sheetId}")
    public ResponseEntity<SheetDTO> readSheet(@PathVariable Long sheetId) {
            Sheet sheetFound = sheetService.read(sheetId);
            return new ResponseEntity<>(sheetAssembler.toResource(sheetFound), HttpStatus.OK);
    }

    @PutMapping(value = "/sheet/{sheetId}")
    public ResponseEntity<SheetDTO> updateSheet(@PathVariable Long sheetId, @RequestBody SheetDTO sheetDTO) {
            Sheet sheet = sheetAssembler.getSheetMapper().sheetDTOToSheet(sheetDTO);
            Sheet sheetUpdated = sheetService.update(sheetId, sheet);
            return new ResponseEntity<>(sheetAssembler.toResource(sheetUpdated), HttpStatus.OK);
    }

    @DeleteMapping(value = "/sheet/{sheetId}")
    public ResponseEntity<SheetDTO> deleteSheet(@PathVariable Long sheetId) {
            Sheet sheetToDelete = sheetService.delete(sheetId);
            return new ResponseEntity<>(sheetAssembler.toResource(sheetToDelete), HttpStatus.OK);
    }

    @GetMapping("/project/{projectId}/sheet")
    public ResponseEntity<SheetListDTO> getAllSheets(@ApiParam Pageable pageable, @PathVariable Long projectId) {
        SheetList sheetList = sheetService.getAll(pageable);
        return new ResponseEntity<>(sheetListAssembler.toResource(sheetList), HttpStatus.OK);
    }


    @GetMapping(value = "/_search/sheet")
    public ResponseEntity<SheetListDTO> searchSheetByName(@RequestParam(value = "name") String name) {
        SheetList sheetList = sheetService.search(name);
        return new ResponseEntity<>(sheetListAssembler.toResource(sheetList), HttpStatus.OK);
    }
}
