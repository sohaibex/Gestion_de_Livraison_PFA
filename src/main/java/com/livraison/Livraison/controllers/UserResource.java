package com.livraison.Livraison.controllers;

import com.livraison.Livraison.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserResource {
    @GetMapping("/home")
    public String showUser()
    {
        return "salam application works fine";
    }
}
