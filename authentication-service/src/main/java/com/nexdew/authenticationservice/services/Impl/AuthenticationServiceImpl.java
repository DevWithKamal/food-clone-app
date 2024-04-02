package com.nexdew.authenticationservice.services.Impl;


import com.nexdew.authenticationservice.dto.*;
import com.nexdew.authenticationservice.entities.Permissions;
import com.nexdew.authenticationservice.entities.Role;
import com.nexdew.authenticationservice.entities.User;
import com.nexdew.authenticationservice.repository.OTPRepository;
import com.nexdew.authenticationservice.repository.UserRepository;
import com.nexdew.authenticationservice.services.AuthenticationService;
import com.nexdew.authenticationservice.services.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JWTService jwtService;

    private  final OTPRepository otpRepository;



    @Override
    public User signUp(SignUpRequest signUpRequest) {
        User user = new User();
        Role role=new Role();
        role.setName("USER");
        Permissions permissions=new Permissions();
        permissions.setName("Place Order");
        role.setPermissions(List.of(permissions));
        user.setRole(role);
      //  user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        userRepository.save(user);

        return user;
    }

//    @Override
//    public JWTAuthenticationResponse signIn(SignInRequest signInRequest) {
//
//
//        try
//        {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
//                    (signInRequest.getEmail(), signInRequest.getPassword()));
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        var user = userRepository.findByEmail(signInRequest.getEmail())
//                .orElseThrow(() -> new
//                        IllegalArgumentException("Invalid mail or password"));
//        otpRepository.findByContactNo()
//
//        var jwt = jwtService.generateToken(user);
//        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);
//
//        JWTAuthenticationResponse jwtAuthenticationResponse = new JWTAuthenticationResponse();
//        jwtAuthenticationResponse.setToken(jwt);
//        jwtAuthenticationResponse.setRefreshToken(refreshToken);
//
//        return jwtAuthenticationResponse;
//
//
//    }

    @Override
    public JWTAuthenticationResponse signIn(OtpRequest otpRequest) {



        Optional<User> userOptional;
           userOptional=userRepository.findUserByContactNo(otpRequest.getContactNo());


        if(userOptional.isEmpty()){
            User user = new User();
            Role role=new Role();
            role.setName("USER");
            Permissions permissions=new Permissions();
            permissions.setName("Place Order");
            role.setPermissions(List.of(permissions));
            user.setRole(role);
            user.setContactNo(otpRequest.getContactNo());
            user.setOtp(otpRequest.getOtp());
            userRepository.save(user);
            userOptional=Optional.of(user);

        }

        var jwt = jwtService.generateToken(userOptional.get());
        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), userOptional.get());

        JWTAuthenticationResponse jwtAuthenticationResponse = new JWTAuthenticationResponse();
        jwtAuthenticationResponse.setToken(jwt);
       // jwtAuthenticationResponse.setRefreshToken(refreshToken);

        return jwtAuthenticationResponse;


    }


    //
//@Override
//    public JWTAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest)
//    {
//        String userEmail=jwtService.extractUserName(refreshTokenRequest.getToken());
//        User user=userRepository.findByEmail(userEmail).orElseThrow();
//        if(jwtService.isTokenValid(refreshTokenRequest.getToken(),user)){
//
//            var jwt=jwtService.generateToken(user);
//            JWTAuthenticationResponse jwtAuthenticationResponse=new JWTAuthenticationResponse();
//            jwtAuthenticationResponse.setToken(jwt);
//            jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());
//
//            return jwtAuthenticationResponse;
//
//        }
//
//        return  null;
//    }
}


