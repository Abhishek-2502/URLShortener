package com.url.shortner.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;


public class JwtAuthenticationResponse {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public JwtAuthenticationResponse() {
    }
}
