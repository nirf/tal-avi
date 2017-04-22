package com.talavi.service;


import com.talavi.security.model.JwtRegistrationRequest;

/**
 * Created by home on 4/7/17.
 */
public interface UserService {
    void register(JwtRegistrationRequest jwtRegistrationRequest);
}
