package com.nexdew.authenticationservice.controller;

import com.nexdew.authenticationservice.dto.UserProfileRequest;
import com.nexdew.authenticationservice.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userProfile")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping("/createProfile")
    public ResponseEntity<UserProfileRequest> createUserProfile(@RequestBody UserProfileRequest userProfileRequest)
    {
       return ResponseEntity.ok(userProfileService.createUserProfile(userProfileRequest));
    }
}
