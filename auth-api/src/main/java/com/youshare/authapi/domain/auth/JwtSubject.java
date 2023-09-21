package com.youshare.authapi.domain.auth;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.youshare.authapi.domain.user.User;

@JsonSerialize
public record JwtSubject(Long id, String username, Boolean active) {
    public JwtSubject(User user){
        this(user.getId(), user.getUsername(), user.getActive());
    }

    // TODO: Correct Serialize this object into Json.
    @Override
    public String toString(){
        return "{id: " + this.id + ", username: " + this.username + ", active: " + this.active + "}";
    }
}
