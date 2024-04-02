package com.nexdew.authenticationservice.services;

import com.nexdew.authenticationservice.dto.JWTAuthenticationResponse;
import com.nexdew.authenticationservice.dto.OtpRequest;
import com.nexdew.authenticationservice.entities.OTP;


public interface OtpService {

    OTP sendOTP(String contactNo);

    JWTAuthenticationResponse verifyOTP(OtpRequest otpRequest);
}
