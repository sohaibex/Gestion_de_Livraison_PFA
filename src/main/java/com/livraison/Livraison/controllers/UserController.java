package com.livraison.Livraison.controllers;

import com.livraison.Livraison.models.User;
import com.livraison.Livraison.requests.UserRequest;
import com.livraison.Livraison.responses.UserResponse;
import com.livraison.Livraison.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {
   //Injection de dependance
    @Autowired
    UserService userService ;

    @GetMapping(path="/{id}")
    public String getUser(@PathVariable String UserId)
    {
        return "the user id is "+UserId;
    }


    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest)
    {
        //user dto
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
/*
    @DeleteMapping(path="/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable String id) {

        userService.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/
}
