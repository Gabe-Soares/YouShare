package com.youshare.authapi.domain.user.service;

import com.youshare.authapi.domain.user.User;

public interface UserService {
    public User getUserByUsername(String username);
}
