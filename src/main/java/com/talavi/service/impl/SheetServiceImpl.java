package com.talavi.service.impl;

import com.talavi.model.domain.Project;
import com.talavi.model.domain.Sheet;
import com.talavi.model.domain.list.SheetList;
import com.talavi.repository.SheetRepository;
import com.talavi.service.SheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by home on 4/20/17.
 */
@Service
@Transactional
public class SheetServiceImpl implements SheetService {
    private SheetRepository sheetRepository;

    @Autowired
    public SheetServiceImpl(SheetRepository sheetRepository) {
        this.sheetRepository = sheetRepository;
    }

    @Override
    public Sheet create(Sheet sheet, Long projectId) {
        Project project = new Project(projectId);
        sheet.setProject(project);
        Sheet sheetCreated = sheetRepository.save(sheet);
        return sheetCreated;
    }

    @Override
    public Sheet read(Long id) {
        return null;
    }

    @Override
    public Sheet update(Long id, Sheet sheet) {
        return null;
    }

    @Override
    public Sheet delete(Long id) {
        return null;
    }

    @Override
    public SheetList getAll(Pageable pageable) {
        return null;
    }

    @Override
    public SheetList search(String name) {
        return null;
    }
}
