package com.nexdew.authenticationservice.controller;

import com.nexdew.authenticationservice.dto.JWTAuthenticationResponse;
import com.nexdew.authenticationservice.dto.OtpRequest;
import com.nexdew.authenticationservice.entities.User;
import com.nexdew.authenticationservice.services.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/otp")
public class OTPController {

    @Autowired
    private OtpService otpService;
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
}
