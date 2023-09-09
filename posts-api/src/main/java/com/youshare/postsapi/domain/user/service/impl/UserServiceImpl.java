package com.youshare.postsapi.domain.user.service.impl;

import com.youshare.postsapi.domain.user.User;
import com.youshare.postsapi.domain.user.UserRepository;
import com.youshare.postsapi.domain.user.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
