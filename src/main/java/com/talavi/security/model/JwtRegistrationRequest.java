package com.talavi.security.model;


import com.talavi.model.domain.Authority;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * Created by home on 4/7/17.
 */
public class JwtRegistrationRequest implements Serializable {
    @Pattern(regexp = "^[_'.@A-Za-z0-9-]*$")
    @NotNull
    @Size(min = 1, max = 50)
    private String username;

    @NotNull
    @Size(min = 4, max = 10)
    private String password;

    @NotNull
    @Size(min = 4, max = 20)
    private String firstname;

    @NotNull
    @Size(min = 4, max = 20)
    private String lastname;

    @Email
    @Size(min = 5, max = 100)
    private String email;

    private List<Authority> authorities;

    public JwtRegistrationRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }


}
