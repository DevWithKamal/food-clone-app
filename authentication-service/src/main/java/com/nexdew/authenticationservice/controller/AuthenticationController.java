package com.nexdew.authenticationservice.controller;


import com.nexdew.authenticationservice.dto.*;
import com.nexdew.authenticationservice.entities.User;
import com.nexdew.authenticationservice.services.AuthenticationService;
import com.nexdew.authenticationservice.services.OtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {


    @Autowired
    private OtpService otpService;

    private final AuthenticationService authenticationService;

    @PostMapping(value = "/signUp")
    public ResponseEntity<User> signUp(@RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authenticationService.signUp(signUpRequest));
    }

    @PostMapping("/signIn")
    public ResponseEntity<JWTAuthenticationResponse> signIn(@RequestBody OtpRequest otpRequest) {
        return ResponseEntity.ok(authenticationService.signIn(otpRequest));
    }


    @PostMapping("/createOtp/{contactNumber}")
    public ResponseEntity<String> createOtp(@PathVariable String contactNumber)
    {
        otpService.sendOTP(contactNumber);

        return ResponseEntity.ok("Otp send successfully");
    }

    @PostMapping("/verifyOtp")
    public  ResponseEntity<JWTAuthenticationResponse> verifyOtp(@RequestBody OtpRequest otpRequest)
    {
        return ResponseEntity.ok(otpService.verifyOTP(otpRequest));
    }
//    @PostMapping("/refreshToken")
//    public ResponseEntity<JWTAuthenticationResponse> refreshTokenRequest(@RequestBody RefreshTokenRequest refreshTokenRequest) {
//        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
//    }

}
