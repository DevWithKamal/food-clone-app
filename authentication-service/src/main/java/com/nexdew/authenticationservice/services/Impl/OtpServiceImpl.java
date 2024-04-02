package com.nexdew.authenticationservice.services.Impl;

import com.nexdew.authenticationservice.dto.JWTAuthenticationResponse;
import com.nexdew.authenticationservice.dto.OtpRequest;
import com.nexdew.authenticationservice.entities.OTP;

import com.nexdew.authenticationservice.repository.OTPRepository;
import com.nexdew.authenticationservice.services.AuthenticationService;
import com.nexdew.authenticationservice.services.OtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class OtpServiceImpl  implements OtpService {
    @Autowired
    private OTPRepository otpRepository;

    private final AuthenticationService authenticationService;
    @Override
    public OTP sendOTP(String contactNo) {


        OTP otp=OTP.builder().
                contactNo(contactNo)
                .otp("11111")
                .build();

        return otpRepository.save(otp);
    }

    @Override
    public JWTAuthenticationResponse verifyOTP(OtpRequest otpRequest) {




       boolean isValid= otpRepository.existsByContactNoAndOtp(otpRequest.getContactNo(),otpRequest.getOtp());



       if(isValid)
       {
         return  authenticationService.signIn(otpRequest);

       }


        return null;
    }


}
