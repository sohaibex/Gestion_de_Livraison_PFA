package com.livraison.Livraison.controllers;

import com.livraison.Livraison.models.ResponsableAgence;
import com.livraison.Livraison.services.impl.ResponsableAgentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;  

@RestController
@RequestMapping("/ResponsableAgence")
public class ResponsableAgenceController {

    private ResponsableAgentService responsableAgentService;

    public ResponsableAgenceController(ResponsableAgentService responsableAgentService){
        this.responsableAgentService = responsableAgentService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ResponsableAgence>> gettAllResponsableAgent()
    {
        List<ResponsableAgence> responsableAgences = responsableAgentService.gettAllResponsableAgent();
        return new ResponseEntity<>(responsableAgences, HttpStatus.OK);
    }

    @GetMapping("/getRespeAgent/{id}")
    public ResponseEntity<List<ResponsableAgence>> getResponsablAgentById(@PathVariable("id") Long id)
    {
        ResponsableAgence responsableAgence = responsableAgentService.getResponsablAgentById(id);
        return new ResponseEntity(responsableAgence, HttpStatus.OK);
    }

    @PostMapping("/AddRespAgent")
    public ResponseEntity<ResponsableAgence> addResponsableAgent(@RequestBody ResponsableAgence responsableAgence)
    {
        ResponsableAgence newResponsableAgent = responsableAgentService.addResponsableAgence(responsableAgence);
        return new ResponseEntity<>(newResponsableAgent, HttpStatus.CREATED);
    }

    @PutMapping("/updateRespAgent")
    public ResponseEntity<ResponsableAgence> updateResponsableAgent(@RequestBody ResponsableAgence responsableAgence)
    {
        ResponsableAgence updateResponsableAgent = responsableAgentService.updateResponsableAgence(responsableAgence);
        return new ResponseEntity<>(updateResponsableAgent, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteResponsableAgent(@PathVariable("id") Long id)
    {
        responsableAgentService.deleteResponsableAgent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
