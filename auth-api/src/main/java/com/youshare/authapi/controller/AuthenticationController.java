package com.youshare.authapi.controller;

import com.youshare.authapi.domain.user.User;
import com.youshare.authapi.domain.auth.dto.AuthDTO;
import com.youshare.authapi.domain.auth.dto.JwtResponseDTO;
import com.youshare.authapi.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthDTO authDto){
        var authenticationToken = new UsernamePasswordAuthenticationToken(authDto.username(), authDto.password());
        var auth = manager.authenticate(authenticationToken);

        var tokenJwt = tokenService.generateJwt((User) auth.getPrincipal());

        return ResponseEntity.ok(new JwtResponseDTO(tokenJwt));
    }
}
