package com.youshare.authapi.domain.user.service.impl;

import com.youshare.authapi.domain.user.User;
import com.youshare.authapi.domain.user.UserRepository;
import com.youshare.authapi.domain.user.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(EntityNotFoundException::new);
    }
}
