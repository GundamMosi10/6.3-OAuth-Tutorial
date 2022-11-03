package com.company.authorizationservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserInfoController {

    @RequestMapping(value = "/userinfo", method = RequestMethod.GET)
    public Principal getUserInfo(Principal principal) {
        System.out.println("CALLED userinfo");
        return principal;
    }
}

//This is created where applications like the oauth-greeter can validate their tokens and get the user data associated
// with the token.
//This is a simple REST API endpoint
//Spring security will inject the Principal associated with the token
//the endpoints returns the Principal.
