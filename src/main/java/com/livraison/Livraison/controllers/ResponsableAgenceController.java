package com.livraison.Livraison.controllers;

import com.livraison.Livraison.entities.ResponsableAgence;
import com.livraison.Livraison.responses.UserResponse;
import com.livraison.Livraison.services.impl.ResponsableAgentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ResponsableAgence")
public class ResponsableAgenceController {

    private ResponsableAgentService responsableAgentService;

    public ResponsableAgenceController(ResponsableAgentService responsableAgentService){
        this.responsableAgentService = responsableAgentService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserResponse>> gettAllResponsableAgent(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "4") int limit) {

        List<UserResponse> usersResponse = new ArrayList<>();

        List<ResponsableAgence> users = responsableAgentService.gettAllResponsableAgent(page, limit);

        for (ResponsableAgence responsableAgenceDto : users) {

            ModelMapper modelMapper = new ModelMapper();
            UserResponse userResponse = modelMapper.map(responsableAgenceDto, UserResponse.class);

            usersResponse.add(userResponse);
        }

        return new ResponseEntity<List<UserResponse>>(usersResponse, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<ResponsableAgence>> getResponsablAgentById(@PathVariable("id") Long id)
    {
        ResponsableAgence responsableAgence = responsableAgentService.getResponsablAgentById(id);
        return new ResponseEntity(responsableAgence, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserResponse> addResponsableAgent(@RequestBody ResponsableAgence responsableAgence)
    {
        ResponsableAgence newResponsableAgent = responsableAgentService.addResponsableAgence(responsableAgence);
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(newResponsableAgent, userResponse);
        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<ResponsableAgence> updateResponsableAgent(@RequestBody ResponsableAgence responsableAgence)
    {
        ResponsableAgence updateResponsableAgent = responsableAgentService.updateResponsableAgence(responsableAgence);
        return new ResponseEntity<>(updateResponsableAgent, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteResponsableAgent(@PathVariable("id") Long id)
    {
        responsableAgentService.deleteResponsableAgent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
