package com.nexdew.authenticationservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    @GetMapping("/hello")
    public String hello(){
        try {
            return "Hi this is User";
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

