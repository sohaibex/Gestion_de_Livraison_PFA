package com.livraison.Livraison.controllers;


import com.livraison.Livraison.entities.LivreurEntity;
import com.livraison.Livraison.requests.UserRequest;
import com.livraison.Livraison.responses.UserResponse;
import com.livraison.Livraison.services.LivreurService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Livreur")
public class LivreurController {
   //Injection de dependance
    @Autowired
    LivreurService livreurService ;
/*

    @GetMapping(path="/{id}")
    public ResponseEntity<UserResponse> getSuperAdminById(@PathVariable String id)
    {
        SuperAdminEntity superAdminDto= superAdminService.getSuperAdminById(id);
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(superAdminDto,userResponse);
        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
    }
*/


    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest)
    {
        //user dto
        LivreurEntity livreur = new LivreurEntity();
        BeanUtils.copyProperties(userRequest,livreur);

        LivreurEntity createLivreur= livreurService.createLivreur(livreur);

        UserResponse userResponse = new UserResponse();

        BeanUtils.copyProperties(createLivreur,userResponse);

        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);

    }


/*
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
*/
}
