package com.nexdew.authenticationservice.services;

import com.nexdew.authenticationservice.dto.UserProfileRequest;
import com.nexdew.authenticationservice.entities.UserProfile;

public interface UserProfileService {

    UserProfileRequest createUserProfile(UserProfileRequest userProfileRequest);
}
