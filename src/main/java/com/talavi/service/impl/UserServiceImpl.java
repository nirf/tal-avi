package com.talavi.service.impl;

import com.google.common.collect.Lists;
import com.talavi.model.domain.AuthorityName;
import com.talavi.model.domain.User;
import com.talavi.security.model.JwtRegistrationRequest;
import com.talavi.repository.AuthorityRepository;
import com.talavi.repository.UserRepository;
import com.talavi.service.UserService;
import com.talavi.service.exception.UserExistsException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by home on 4/7/17.
 */
@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LogManager.getLogger(this.getClass());

    private UserRepository userRepository;

    private AuthorityRepository authorityRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           AuthorityRepository authorityRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void register(JwtRegistrationRequest jwtRegistrationRequest) {
        User userByUsername = userRepository.findByUsername(jwtRegistrationRequest.getUsername());
        if (userByUsername != null) {
            throw new UserExistsException(String.format("username:%s already exists", userByUsername.getUsername()));
        }

        User userByEmail = userRepository.findByEmail(jwtRegistrationRequest.getEmail());
        if (userByEmail != null) {
            throw new UserExistsException(String.format("Email:%s already exists", userByUsername.getEmail()));
        }

        User user = new User();
        user.setFirstname(jwtRegistrationRequest.getFirstname());
        user.setLastname(jwtRegistrationRequest.getLastname());
        user.setUsername(jwtRegistrationRequest.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(jwtRegistrationRequest.getPassword()));
        user.setAuthorities(Lists.newArrayList(authorityRepository.findByName(AuthorityName.ROLE_USER)));
        user.setEmail(jwtRegistrationRequest.getEmail());
        user.setLastPasswordResetDate(new Date());
        user.setEnabled(true);
        userRepository.save(user);
    }
}
