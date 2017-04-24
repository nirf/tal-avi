package com.talavi.repository;

import com.talavi.model.domain.Project;
import com.talavi.model.domain.Sheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by home on 4/20/17.
 */
@Repository
public interface SheetRepository extends JpaRepository<Sheet, Long> {
}
