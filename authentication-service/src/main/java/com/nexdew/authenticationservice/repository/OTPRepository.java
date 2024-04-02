package com.nexdew.authenticationservice.repository;

import com.nexdew.authenticationservice.common.repository.BaseRepository;
import com.nexdew.authenticationservice.entities.OTP;

import java.util.UUID;

public interface OTPRepository extends BaseRepository<OTP, UUID> {

             boolean existsByContactNoAndOtp(String contactNo,String otp);

             OTP findByContactNo(String contactNo);
}
