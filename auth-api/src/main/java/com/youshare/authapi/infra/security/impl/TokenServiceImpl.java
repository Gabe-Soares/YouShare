package com.youshare.authapi.infra.security.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.youshare.authapi.domain.auth.JwtSubject;
import com.youshare.authapi.domain.user.User;
import com.youshare.authapi.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenServiceImpl implements TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    @Value("${api.security.token.validity}")
    private Integer validity;

    @Value("${api.security.token.zoneoffset}")
    private String zoneOffSet;

    @Override
    public String generateJwt(User user) {
        System.out.println("keys:" + secret + " - " + validity.toString() + " - " + zoneOffSet);

        try {
            var alg = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("YouShare")
                    .withSubject(new JwtSubject(user).toString())
                    .withExpiresAt(this.expireDate())
                    .sign(alg);
        }
        catch (JWTCreationException e) {
            throw new RuntimeException("Failed to generate JWT Token.", e);
        }

    }

    @Override
    public JwtSubject getJwtSubject(String token) {
        return null;
    }

    private Instant expireDate() {
        return LocalDateTime.now().plusHours(validity).toInstant(ZoneOffset.of(zoneOffSet));
    }
}
