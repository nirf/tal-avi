package com.talavi.service;

import com.talavi.model.domain.Sheet;
import com.talavi.model.domain.list.SheetList;
import org.springframework.data.domain.Pageable;


/**
 * Created by home on 4/20/17.
 */
public interface SheetService {
    Sheet create(Sheet sheet, Long projectId);

    Sheet read(Long id);

    Sheet update(Long id, Sheet sheet);

    Sheet delete(Long id);

    SheetList getAll(Pageable pageable);

    SheetList search(String name);

}
