package com.livraison.Livraison.controllers;

import com.livraison.Livraison.entities.RegionEntity;
import com.livraison.Livraison.entities.VilleEntity;
import com.livraison.Livraison.responses.UserResponse;
import com.livraison.Livraison.services.VilleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Ville")
public class VilleController {
    @Autowired
    VilleService villeService;



    @GetMapping()
    public ResponseEntity<List<UserResponse>> getAllSuperAdmins(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "4") int limit) {

        List<UserResponse> usersResponse = new ArrayList<>();
        List<VilleEntity> users = villeService.getAllVilles(page, limit);

        for (VilleEntity VilleDto : users) {

            ModelMapper modelMapper = new ModelMapper();
            UserResponse userResponse = modelMapper.map(VilleDto, UserResponse.class);

            usersResponse.add(userResponse);
        }

        return new ResponseEntity<List<UserResponse>>(usersResponse, HttpStatus.OK);
    }
}
