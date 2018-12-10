package com.rest.angtestrest.controller;

import com.rest.angtestrest.dto.AuthResponse;
import com.rest.angtestrest.dto.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class AuthenticationController {

    @PostMapping("/authenticate")
    public AuthResponse autheticate(@RequestBody UserDetails userDetails){
        System.out.println(userDetails.getPassword());
        System.out.println(userDetails.getUsername());
        AuthResponse authResponse = new AuthResponse();
        if("admin".equals(userDetails.getUsername())
                && "admin".equals(userDetails.getPassword())){
            authResponse.setSuccess(true);
            authResponse.setSecret("Secret of the admin");
        } else {
            authResponse.setSuccess(false);
            authResponse.setMessage("Invalid Credentials");
        }
        return authResponse;
    }

}
