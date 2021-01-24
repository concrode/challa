package com.example.challa.payload.request;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest implements Serializable {
    private String username;
    private String password;
}
