package com.nexdew.authenticationservice.dto;


import lombok.Data;

import java.util.Date;
@Data
public class UserProfileRequest {


    private  String contactNo;



    private String email;

    private Date dateOfBirth;

    private  Date anniversary;
    private String gender;
}
