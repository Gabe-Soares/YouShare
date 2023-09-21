package com.youshare.authapi.infra.security;

import com.youshare.authapi.domain.auth.JwtSubject;
import com.youshare.authapi.domain.user.User;

public interface TokenService {
    public String generateJwt(User user);

    public JwtSubject getJwtSubject(String token);
}
