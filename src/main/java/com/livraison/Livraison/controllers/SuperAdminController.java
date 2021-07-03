package com.livraison.Livraison.controllers;

import com.livraison.Livraison.entities.SuperAdminEntity;
import com.livraison.Livraison.models.User;
import com.livraison.Livraison.requests.UserRequest;
import com.livraison.Livraison.responses.UserResponse;
import com.livraison.Livraison.services.SuperAdminService;
import com.livraison.Livraison.services.impl.SuperAdminServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/SuperAdmin")
public class SuperAdminController {
    //Injection de dependance
    @Autowired
    SuperAdminService superAdminService;


    @GetMapping()
    public ResponseEntity<List<UserResponse>> getAllSuperAdmins(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "4") int limit) {

        List<UserResponse> usersResponse = new ArrayList<>();

        List<SuperAdminEntity> users = superAdminService.getAllSuperAdmins(page, limit);

        for (SuperAdminEntity SuperAdminDto : users) {

            ModelMapper modelMapper = new ModelMapper();
            UserResponse userResponse = modelMapper.map(SuperAdminDto, UserResponse.class);

            usersResponse.add(userResponse);
        }

        return new ResponseEntity<List<UserResponse>>(usersResponse, HttpStatus.OK);
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponse> getSuperAdminById(@PathVariable String id) {
        SuperAdminEntity superAdminDto = superAdminService.getSuperAdminById(id);
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(superAdminDto, userResponse);
        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        //user dto
        SuperAdminEntity superAdmin = new SuperAdminEntity();
        BeanUtils.copyProperties(userRequest, superAdmin);

        SuperAdminEntity createSuperAdmin = superAdminService.createSuperAdmin(superAdmin);

        UserResponse userResponse = new UserResponse();

        BeanUtils.copyProperties(createSuperAdmin, userResponse);

        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);

    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<UserResponse> updateSuperAdmin(@PathVariable String id, @RequestBody UserRequest userRequest) {
        //user dto
        SuperAdminEntity superAdminDto = new SuperAdminEntity();
        BeanUtils.copyProperties(userRequest, superAdminDto);

        SuperAdminEntity updateSuperAdmin = superAdminService.updateSuperAdmin(id, superAdminDto);

        UserResponse userResponse = new UserResponse();

        BeanUtils.copyProperties(updateSuperAdmin, userResponse);

        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.ACCEPTED);
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteSuperAdmin(@PathVariable String id) {

        superAdminService.deleteSuperAdmin(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
