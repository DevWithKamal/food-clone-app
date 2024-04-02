package com.nexdew.authenticationservice.services;


import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JWTService {

    String generateToken(UserDetails userDetails);

    String extractUserName(String token);



    public boolean isTokenValid(String token,UserDetails userDetails);


    String generateRefreshToken(Map<String, Object> extraClaims, UserDetails userDetails);
}
