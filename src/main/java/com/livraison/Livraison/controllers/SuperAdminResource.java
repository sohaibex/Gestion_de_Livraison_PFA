package com.livraison.Livraison.controllers;

import com.livraison.Livraison.entities.SuperAdminEntity;
import com.livraison.Livraison.models.User;
import com.livraison.Livraison.requests.UserRequest;
import com.livraison.Livraison.responses.UserResponse;
import com.livraison.Livraison.services.SuperAdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/SuperAdmin")
public class SuperAdminResource {
    //Injection de dependance
    @Autowired
    SuperAdminService superAdminService ;

    @GetMapping(path="/{id}")
    public ResponseEntity<UserResponse>getSuperAdminById(@PathVariable String id)
    {
        SuperAdminEntity superAdminDto= superAdminService.getSuperAdminById(id);
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(superAdminDto,userResponse);
        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest)
    {
        //user dto
        SuperAdminEntity superAdmin = new SuperAdminEntity();
        BeanUtils.copyProperties(userRequest,superAdmin);

        SuperAdminEntity createSuperAdmin= superAdminService.createSuperAdmin(superAdmin);

        UserResponse userResponse = new UserResponse();

        BeanUtils.copyProperties(createSuperAdmin,userResponse);

        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);

    }



    @PutMapping(path="/{id}")
    public ResponseEntity<UserResponse> updateSuperAdmin(@PathVariable String id,@RequestBody UserRequest userRequest)
    {
        //user dto
        SuperAdminEntity superAdminDto = new SuperAdminEntity();
        BeanUtils.copyProperties(userRequest,superAdminDto);

        SuperAdminEntity updateSuperAdmin= superAdminService.updateSuperAdmin(id,superAdminDto);

        UserResponse userResponse = new UserResponse();

        BeanUtils.copyProperties(updateSuperAdmin,userResponse);

        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.ACCEPTED);
    }


    @DeleteMapping(path="/{id}")
    public ResponseEntity<Object> deleteSuperAdmin(@PathVariable String id) {

        superAdminService.deletegetSuperAdmin(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
