package com.livraison.Livraison.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfigiration extends WebSecurityConfigurerAdapter {


//Configuration du spring securite
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
              //activation du cors qui permet de communiquer avec plusiers systemes
              .cors().and()
              //desactivation du crf parce qu'on a pas un formulaire
              .csrf().disable()
//autorisation seulement Post request de la route /users
              .authorizeRequests()
              .antMatchers((HttpMethod.POST),"/users")
              .permitAll()
              //tous les autres methodes doivent etre connecte
              .anyRequest().authenticated();
    }


}
