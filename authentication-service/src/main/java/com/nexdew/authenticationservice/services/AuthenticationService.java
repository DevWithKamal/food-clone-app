package com.nexdew.authenticationservice.services;


import com.nexdew.authenticationservice.dto.*;
import com.nexdew.authenticationservice.entities.User;

public interface AuthenticationService {

    public User signUp(SignUpRequest signUpRequest);

  //  JWTAuthenticationResponse signIn(SignInRequest signInRequest);

    JWTAuthenticationResponse signIn(OtpRequest otpRequest);

   // public JWTAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

}
