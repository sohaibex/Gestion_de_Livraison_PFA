package com.livraison.Livraison.controllers;

import com.livraison.Livraison.entities.RegionEntity;
import com.livraison.Livraison.entities.SuperAdminEntity;
import com.livraison.Livraison.responses.RegionResponse;
import com.livraison.Livraison.responses.UserResponse;
import com.livraison.Livraison.services.RegionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/Region")
public class RegionController {

    @Autowired
    RegionService regionService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<RegionResponse> getRegionById(@PathVariable String regionId) {
        RegionEntity superAdminDto = regionService.getRegionById(regionId);
        RegionResponse userResponse = new RegionResponse();
        BeanUtils.copyProperties(superAdminDto, userResponse);
        return new ResponseEntity<RegionResponse>(userResponse, HttpStatus.OK);
    }



    @GetMapping()
    public ResponseEntity<List<RegionResponse>> getAllSuperAdmins(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "4") int limit) {

        List<RegionResponse> usersResponse = new ArrayList<>();
        List<RegionEntity> users = regionService.getAllRergions(page, limit);

        for (RegionEntity RegionDto : users) {

            ModelMapper modelMapper = new ModelMapper();
            RegionResponse userResponse = modelMapper.map(RegionDto, RegionResponse.class);

            usersResponse.add(userResponse);
        }

        return new ResponseEntity<List<RegionResponse>>(usersResponse, HttpStatus.OK);
    }
}
