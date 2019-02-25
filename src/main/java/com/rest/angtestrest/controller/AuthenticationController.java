package com.rest.angtestrest.controller;

import com.rest.angtestrest.dto.AuthResponse;
import com.rest.angtestrest.dto.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public AuthResponse autheticate(@RequestBody UserDetails userDetails){
        System.out.println(userDetails.getPassword());
        System.out.println(userDetails.getUsername());
        AuthResponse authResponse = new AuthResponse();
        if("admin".equals(userDetails.getUsername())
                && "admin".equals(userDetails.getPassword())){
            authResponse.setSuccess(true);
            authResponse.setSecret("Secret of the admin");
        } else if("joe1506".equals(userDetails.getUsername())
                && "joe1506".equals(userDetails.getPassword())){
            authResponse.setSuccess(true);
            authResponse.setSecret("Secret of the user");
        } else {
            authResponse.setSuccess(false);
            authResponse.setMessage("Invalid Credentials");
        }


        String role = "USER";
        if(userDetails.getUsername().equalsIgnoreCase("admin")){
            role="ADMIN";
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        GrantedAuthority ga = new SimpleGrantedAuthority(role);
        grantedAuthorities.add(ga);

        UsernamePasswordAuthenticationToken loginToken = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), grantedAuthorities);
        Authentication auth = authenticationManager.authenticate(loginToken);
        SecurityContextHolder.getContext().setAuthentication(auth);
        return authResponse;
    }

}
