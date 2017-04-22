package com.talavi.repository;


import com.talavi.model.domain.Authority;
import com.talavi.model.domain.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by home on 4/7/17.
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(AuthorityName name);
}
