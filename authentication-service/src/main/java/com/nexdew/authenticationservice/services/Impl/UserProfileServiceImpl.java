package com.nexdew.authenticationservice.services.Impl;

import com.nexdew.authenticationservice.dto.UserProfileRequest;
import com.nexdew.authenticationservice.entities.User;
import com.nexdew.authenticationservice.entities.UserProfile;
import com.nexdew.authenticationservice.repository.UserProfileRepository;
import com.nexdew.authenticationservice.repository.UserRepository;
import com.nexdew.authenticationservice.services.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;
    @Autowired
    private UserRepository userRepository;




    @Override
    public UserProfileRequest createUserProfile(UserProfileRequest userProfileRequest) {

        boolean isPresent=userRepository.findUserByContactNo(userProfileRequest.getContactNo()).isEmpty();


            User user=userRepository.findUserByContactNo(userProfileRequest.getContactNo()).get();

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.map(userProfileRequest,UserProfile.class);

        UserProfile userProfile=modelMapper.map(userProfileRequest,UserProfile.class);
        userProfile.setCreatedBy(userProfile.getEmail());
        userProfile.setCreatedDate(new Date());
        userProfile.setIsDeleted(Boolean.FALSE);
        userProfile.setLastModifiedDate(new Date());
        userProfile.setLastModifiedBy(userProfile.getEmail());
        userProfile.setUser(user);

        userProfileRepository.save(userProfile);

        return  modelMapper.map(userProfile,UserProfileRequest.class);
    }


}
