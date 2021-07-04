package com.livraison.Livraison.controllers;


import com.livraison.Livraison.services.AgencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Agence")
public class AgencesController {

    @Autowired
    AgencesService agencesService;

    

}
