package com.rest.angtestrest.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@CrossOrigin
@RestController
public class UserController {

    @GetMapping("/username")
    public boolean currentUserName(Principal principal) {
        String username = principal.getName();
        if(StringUtils.isEmpty(username)){
            return false;
        } else {
            return true;
        }
        /*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null){
            String username= (String) authentication.getPrincipal();
            if(StringUtils.isEmpty(username)){
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }*/
    }

}




