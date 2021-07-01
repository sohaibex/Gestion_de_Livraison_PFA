package com.livraison.Livraison.controllers;


import com.livraison.Livraison.entities.VendeurEntity;
import com.livraison.Livraison.entities.VendeurEntity;
import com.livraison.Livraison.requests.UserRequest;
import com.livraison.Livraison.responses.UserResponse;
import com.livraison.Livraison.services.SuperAdminService;
import com.livraison.Livraison.services.VendeurService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Vendeur")
public class VendeurController {
    //Injection de dependance
    @Autowired
    VendeurService vendeurService;

    @PostMapping
    public ResponseEntity<UserResponse> createVendeur(@RequestBody UserRequest userRequest) {
        //user dto
        VendeurEntity vendeur = new VendeurEntity();
        BeanUtils.copyProperties(userRequest, vendeur);

        VendeurEntity createVendeur = vendeurService.createVendeur(vendeur);

        UserResponse userResponse = new UserResponse();

        BeanUtils.copyProperties(createVendeur, userResponse);

        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);

    }


    @GetMapping()
    public ResponseEntity<List<UserResponse>> getAllVendeurs(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "4") int limit) {

        List<UserResponse> usersResponse = new ArrayList<>();

        List<VendeurEntity> users = vendeurService.getAllVendeurs(page, limit);

        for (VendeurEntity vendeurDto : users) {

            ModelMapper modelMapper = new ModelMapper();
            UserResponse userResponse = modelMapper.map(vendeurDto, UserResponse.class);

            usersResponse.add(userResponse);
        }

        return new ResponseEntity<List<UserResponse>>(usersResponse, HttpStatus.OK);
    }




    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponse> getVendeurById(@PathVariable String id) {
        VendeurEntity vendeurDto = vendeurService.getVendeurById(id);
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(vendeurDto, userResponse);
        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
    }





   @PutMapping(path = "/{id}")
    public ResponseEntity<UserResponse> updateSuperAdmin(@PathVariable String id, @RequestBody UserRequest userRequest) {
       //user dto
       VendeurEntity vendeurDto = new VendeurEntity();
       BeanUtils.copyProperties(userRequest, vendeurDto);

       VendeurEntity updateVendeur= vendeurService.updateVendeur(id, vendeurDto);

       UserResponse userResponse = new UserResponse();

       BeanUtils.copyProperties(updateVendeur, userResponse);

       return new ResponseEntity<UserResponse>(userResponse, HttpStatus.ACCEPTED);
   }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteSuperAdmin(@PathVariable String id) {

        vendeurService.deleteVendeur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
