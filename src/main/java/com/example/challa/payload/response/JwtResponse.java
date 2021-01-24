package com.example.challa.payload.response;

import lombok.*;

import java.io.Serializable;
import java.util.List;

public class JwtResponse implements Serializable {
    private final String jwt;

    public JwtResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
