package com.livraison.Livraison.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.livraison.Livraison.SpringApplicationContext;
import com.livraison.Livraison.models.User;
import com.livraison.Livraison.requests.UserLoginRequest;
import com.livraison.Livraison.security.SecurityConstants;
import com.livraison.Livraison.services.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.fasterxml.jackson.databind.ObjectMapper;


public class AuthentificationFilter extends UsernamePasswordAuthenticationFilter {

    //attribut qui gere l authentification
    private final AuthenticationManager authenticationManager;

    //initialisation de l attribut via le contructeur
    public AuthentificationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    //obverride de la methode attemptAuthentication qui nous permet de s authentifier
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException {
        try {

            UserLoginRequest creds = new ObjectMapper().readValue(req.getInputStream(), UserLoginRequest.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getPassword(), new ArrayList<>()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        String username = ((org.springframework.security.core.userdetails.User) auth.getPrincipal()).getUsername();

        UserService userService = (UserService)SpringApplicationContext.getBean("userServiceImpl");

        User userDto = userService.getUser(username);

        String token = Jwts.builder()
                .setSubject(username)
                .claim("id", userDto.getUserId())
                .claim("name", userDto.getNom() + " " + userDto.getPrenom() + " " + userDto.getRole())
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.TOKEN_SECRET)
                .compact();

        res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
        res.addHeader("user_id", userDto.getUserId());
        res.getWriter().write("{\"token\": \"" + token + "\", \"User_id\": \"" + userDto.getUserId() + "\"}");

    }

}