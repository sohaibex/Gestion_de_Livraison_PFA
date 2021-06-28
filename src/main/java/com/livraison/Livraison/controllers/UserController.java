package com.livraison.Livraison.controllers;

import com.livraison.Livraison.models.User;
import com.livraison.Livraison.requests.UserRequest;
import com.livraison.Livraison.responses.UserResponse;
import com.livraison.Livraison.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
   //Injection de dependance
    @Autowired
    UserService userService ;

    @GetMapping(path="/{id}")
    public ResponseEntity<UserResponse>getUser(@PathVariable String id)
    {
        User userDto= userService.getUserById(id);
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(userDto,userResponse);
        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest)
    {
        //user dto
        User user = new User();
        BeanUtils.copyProperties(userRequest,user);

       User createUser= userService.createUser(user);

       UserResponse userResponse = new UserResponse();

       BeanUtils.copyProperties(createUser,userResponse);

        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);

    }


    @PutMapping(path="/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable String id,@RequestBody UserRequest userRequest)
    {
        //user dto
        User userDto = new User();
        BeanUtils.copyProperties(userRequest,userDto);

        User updateUser= userService.updateUser(id,userDto);

        UserResponse userResponse = new UserResponse();

        BeanUtils.copyProperties(updateUser,userResponse);

        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.ACCEPTED);
    }


    @DeleteMapping(path="/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable String id) {

        userService.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
