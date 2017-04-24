package com.talavi.model.service.mapper;

import com.talavi.model.domain.Sheet;
import com.talavi.model.dto.SheetDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by home on 4/24/17.
 */
@Mapper(componentModel = "spring")
@Component
public interface SheetMapper {
    SheetDTO sheetToSheetDTO(Sheet sheet);

    List<SheetDTO> sheetsToSheetDTOs(List<Sheet> sheets);

    Sheet sheetDTOToSheet(SheetDTO sheetDTO);

    List<Sheet> sheetDTOsToSheets(List<SheetDTO> sheetDTOs);
}
