package com.livraison.demo.controller;

import com.livraison.demo.entity.AuthRequest;
import com.livraison.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private JwtUtil jwUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String bienvenue(){
        return "C est Bon, Hey !!";
    }

    @PostMapping("/authentification")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {

        try{

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );

        }catch (Exception ex){
            throw new Exception("Invalide User Name Or Password !");
        }
        return jwUtil.generateToken(authRequest.getUserName());
    }
}
