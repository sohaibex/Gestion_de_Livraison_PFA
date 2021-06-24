package com.livraison.Livraison.controllers;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.livraison.Livraison.models.User;
import com.livraison.Livraison.requests.UserRequest;
import com.livraison.Livraison.responses.UserResponse;
import com.livraison.Livraison.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")

public class UserResource {
    @Autowired
    UserService userService ;

    @GetMapping
    public String getUser()
    {
        return "get user";
    }


    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest)
    {
        User user = new User();
        BeanUtils.copyProperties(userRequest,user);

       User createUser= userService.createUser(user);

       UserResponse userResponse = new UserResponse();

       BeanUtils.copyProperties(createUser,userResponse);

       return userResponse;

    }


    @PutMapping
    public String updateUser()
    {
        return "Update User";
    }

    @DeleteMapping
    public String deleteUser()
    {
        return "delete User";
    }

}
