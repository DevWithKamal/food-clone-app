package com.nexdew.authenticationservice.dto;

import lombok.Data;

@Data
public class OtpRequest {

    private  String contactNo;

    private  String otp;

}
