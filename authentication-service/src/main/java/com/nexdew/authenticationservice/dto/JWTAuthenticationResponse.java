package com.nexdew.authenticationservice.dto;

import lombok.Data;

@Data
public class JWTAuthenticationResponse {

    private String token;

    private  String refreshToken;
}
