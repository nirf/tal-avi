package com.talavi.controller;

import com.talavi.security.AuthoritiesConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by home on 4/9/17.
 */
@RestController
@RequestMapping("protected")
public class MethodProtectedRestController {

    /**
     * This is an example of some different kinds of granular restriction for endpoints. You can use the built-in SPEL expressions
     * in @PreAuthorize such as 'hasRole()' to determine if a user has access. Remember that the hasRole expression assumes a
     * 'ROLE_' prefix on all role names. So 'ADMIN' here is actually stored as 'ROLE_ADMIN' in database!
     **/
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getProtectedGreeting() {
        return ResponseEntity.ok("Greetings from admin protected method!");
    }
}
